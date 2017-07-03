package testclass;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者消费者模式-阻塞队列
 * @author Administrator
 *
 */
public class ProducerAndConsoumerBolockingQueue {

	public static class Producer implements Runnable{
		private boolean flag;
		private BlockingQueue<Integer> queue;
		private Random radom;
		
		public Producer(BlockingQueue<Integer> queue) {
			super();
			this.flag = false;
			this.queue = queue;
			this.radom = new Random();
		}

		@Override
		public void run() {
			while (!flag) {
				int info = radom.nextInt(100);
				try {
					queue.put(info);
					System.out.println("生产者生产了： " + info + "件商品");
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
		
		private boolean flag;
		private BlockingQueue<Integer> queue ;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Consumer(BlockingQueue queue) {
			super();
			this.flag = true;
			this.queue = queue;
		}
		
		@Override
		public void run() {
			while (flag) {
				try {
					int info = queue.take();
					System.out.println("消费者消费了： " + info + "件商品");
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
	
	public static void main(String[] args) {
		BlockingQueue<Integer> que = new ArrayBlockingQueue<Integer>(10);
		Producer pro = new Producer(que);
		Consumer con = new Consumer(que);
 		for (int i = 0; i < 10; i++) {
 			if (i < 5) {
 				Thread tpro = new Thread(pro);
 				tpro.start();
 			} else {
 				Thread tcon = new Thread(con);
 				tcon.start();
 			}
		}
 		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
 		pro.shutDown();
 		con.shutDown();
	}
}
