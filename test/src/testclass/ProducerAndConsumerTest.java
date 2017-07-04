package testclass;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者消费者测试
 * @author YMGC
 *
 */
public class ProducerAndConsumerTest {
	
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		for (int i = 0; i < 10; i++) {
			if (i < 5) {
				new Thread(producer).start();
			} else {
				new Thread(consumer).start();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		producer.shutDown();
		consumer.shutDown();
	}

	public static class Producer implements Runnable{
		private boolean flag;
		private BlockingQueue<Integer> queue;
		private Random random;
		public Producer(BlockingQueue<Integer> queue) {
			super();
			this.flag = false;
			this.queue = queue;
			this.random = new Random();
		}
		@Override
		public void run() {
			while (!flag) {
				int info = random.nextInt(100);
				try {
					queue.put(info);
					System.out.println(Thread.currentThread().getName() + "生产者生产了：" + info + "件商品");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		public void shutDown(){
			flag = true;
		}
	}
	
	public static class Consumer implements Runnable{

		private BlockingQueue<Integer> queue;
		private boolean flag;
		
		public Consumer(BlockingQueue<Integer> queue) {
			super();
			this.queue = queue;
			this.flag = true;
		}

		@Override
		public void run() {
			while (flag) {
				try {
					int info = queue.take();
					System.out.println(Thread.currentThread().getName() + " 消费者消费了：" + info + "件商品");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void shutDown(){
			flag = false;
		}
		
	}
	
}
