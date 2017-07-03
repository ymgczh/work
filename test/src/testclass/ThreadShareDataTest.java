package testclass;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadShareDataTest {
	
	AtomicInteger age = new AtomicInteger(0);
	private int i = 0;
	public static void main(String[] args) {
		ThreadShareDataTest c1 = new ThreadShareDataTest();
		Inc inc = c1.new Inc();
		Dec dec = c1.new Dec();
		for (int i = 0; i < 2; i++) {
			Thread t1 = new Thread(inc);
			Thread t2 = new Thread(dec);
			t1.start();
			t2.start();
		}
	}

	public synchronized void inc(){
		i++;
		System.out.println(Thread.currentThread().getName() + "_inc_" + i);
	}
	public synchronized void dec(){
		i--;
		System.out.println(Thread.currentThread().getName() + "_dec_" + i);
	}
	
	class Inc implements Runnable{
		@Override
		public void run() {
			for (int j = 0; j < 100; j++) {
				inc();
			}
		}
	}
	
	class Dec implements Runnable{
		@Override
		public void run() {
			for (int j = 0; j < 100; j++) {
				dec();
			}
		}
	}
}
