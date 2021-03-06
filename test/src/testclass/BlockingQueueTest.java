package testclass;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		final BlockingQueue queue = new ArrayBlockingQueue(3);
		for (int i = 0; i < 2; i++) {
			new Thread(){
				@SuppressWarnings("unchecked")
				public void run(){
					try {
						Thread.sleep((long) (Math.random()*1000));
						System.out.println(Thread.currentThread().getName()
								+ "准备放数据");
						queue.put(1);
						System.out.println(Thread.currentThread().getName()
								+ "队列目前有 " + queue.size() + " 个数据");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
		
		new Thread(){
			public void run(){
				while (true) {
					try {
						Thread.sleep(100);
						System.out.println(Thread.currentThread().getName()
								+ "准备取数据");
						queue.take();
						System.out.println(Thread.currentThread().getName()
								+ "队列目前有 " + queue.size() + " 个数据");
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}.start();
		
	}

}
