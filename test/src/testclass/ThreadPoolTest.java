package testclass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPoolTest {

	public static void main(String[] args) {
//		ExecutorService threadPool = Executors.newFixedThreadPool(3);
//		ExecutorService threadPool = Executors.newCachedThreadPool();
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ "loop of " + j + 
								"for task of " + task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have commited");
		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("schedual : ");
			}
		}, 5,2, java.util.concurrent.TimeUnit.SECONDS);
	}

}
