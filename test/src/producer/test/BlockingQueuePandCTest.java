package producer.test;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ��������ʵ��������������ģʽ
 * @since 2017��7��5��20:02:08
 * @author Administrator
 *
 */
public class BlockingQueuePandCTest {

	public static void main(String[] args) {
		BlockingQueue<Integer> que = new ArrayBlockingQueue<>(10);
		Producer pro = new Producer(que);
		Consumer con = new Consumer(que);
		for (int i = 0; i < 10; i++) {
			new Thread(pro).start();
			new Thread(con).start();
		}
		pro.shutdown();
		con.shutdown();
	}
	
	public static class Producer implements Runnable{
		
		private BlockingQueue<Integer> queue;
		private boolean flag;
		private Random radom;
		public Producer(BlockingQueue<Integer> queue) {
			super();
			this.queue = queue;
			this.flag = true;
			this.radom = new Random();
		}
		@Override
		public void run() {
			if (flag) {
				int info = radom.nextInt(100);
				try {
					queue.put(info);
					System.out.println(Thread.currentThread().getName() + "�����ˣ�" + info + "����Ʒ");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void shutdown(){
			flag = false;
		}
	}
	
	public static class Consumer implements Runnable{
		private BlockingQueue<Integer> queue;
		private boolean flag;
		public Consumer(BlockingQueue<Integer> queue) {
			super();
			this.queue = queue;
			this.flag = false;
		}
		@Override
		public void run() {
			if (!flag) {
				try {
					int info = queue.take();
					System.out.println(Thread.currentThread().getName() + "�����ˣ�" + info + "����Ʒ");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void shutdown(){
			flag = true;
		}
	}

}
