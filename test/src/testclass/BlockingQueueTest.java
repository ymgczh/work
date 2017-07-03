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
								+ "׼��������");
						queue.put(1);
						System.out.println(Thread.currentThread().getName()
								+ "����Ŀǰ�� " + queue.size() + " ������");
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
								+ "׼��ȡ����");
						queue.take();
						System.out.println(Thread.currentThread().getName()
								+ "����Ŀǰ�� " + queue.size() + " ������");
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}.start();
		
	}

}