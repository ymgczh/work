package testclass;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public static void main(String[] args) {
		
	}

	static class Outputer{
		Lock lock = new ReentrantLock();
		
		public void out(String name){
			int len = name.length();
			lock.lock();
			try {
				for (int i = 0; i < len; i++) {
					System.out.println(name.charAt(i));
				}
				System.out.println();
			} finally {
				lock.unlock();
			}
				
		}
	}
}
