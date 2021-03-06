package testclass;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ��д������������
 * @author YMGC
 *
 */
public class CacheDemo {

	private Map<String , Object> cache = new HashMap<String , Object>();
	public static void main(String[] args) {
		
	}
	
	ReadWriteLock rwl = new ReentrantReadWriteLock();
	public Object getData(String key){
		rwl.readLock().lock();
		Object obj = null;
		try {
			obj = cache.get(key);
			if (obj == null) {
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try {
					if (obj == null) {
						obj = "test";
					}
				} finally {
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwl.readLock().unlock();
		}
		return obj;
	}
}
