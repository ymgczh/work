package testclass;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class CallableAndFuture {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<String> future = 
		threadPool.submit(new Callable<String>() {
			public String call(){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "hello";
			}
		});
		System.out.println("等待结果");
		try {
			System.out.println("拿到结果" + future.get(1,TimeUnit.SECONDS));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
		CompletionService<Integer> com = new ExecutorCompletionService<Integer>(threadPool2);
		for (int i = 0; i < 10; i++) {
			final int seq = i;
			com.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return seq;
				}
			});
		}
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(com.take().get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	


}
