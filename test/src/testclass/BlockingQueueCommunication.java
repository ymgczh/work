package testclass;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueCommunication {

	public static void main(String[] args) {
		final Business bus = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					bus.sub(i);
				}
			}
		}).start();
		for (int i = 0; i < 50; i++) {
			bus.main(i);
		}
	}
	
	static class Business {
		
		BlockingQueue<Integer> que1 = new ArrayBlockingQueue<Integer>(1);
		BlockingQueue<Integer> que2 = new ArrayBlockingQueue<Integer>(1);
		{
			try {
				que2.put(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void sub(int i) {
			try {
				que1.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int j = 0; j < 10; j++) {
				System.out.println("sub thread seq of " + j + "loop of " + i);
			}
			try {
				que2.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void main(int i) {
			try {
				que2.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int j = 0; j < 100; j++) {
				System.out.println("main thread seq of " + j + "loop of " + i);
			}
			try {
				que1.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
