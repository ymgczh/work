package testclass;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ��д��Ӧ��
 * @author YMGC
 *
 */
public class ReadWriteLockTest {

	public static void main(String[] args) {
		final Queue3 q3 = new Queue3();
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						q3.put(new Random().nextInt(10000));
					}
				}
			}).start();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						q3.get();
					}
				}
			}).start();
		}
		
	}
	
}

class Queue3{
	private Object data = null;
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	public void get(){
		rwl.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "__ready to read data__" );
			Thread.sleep((long)(Math.random()*1000));
			System.out.println(Thread.currentThread().getName() + "__have read data__" + data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwl.readLock().unlock();
		}
	}
	public void put(Object data){
		rwl.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "__be ready to write__" + data);
			Thread.sleep((long)(Math.random()*1000));
			this.data = data;
			System.out.println(Thread.currentThread().getName() + "__have write data__" + data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwl.writeLock().unlock();
		}
	}
}



