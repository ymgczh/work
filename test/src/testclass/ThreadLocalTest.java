package testForEvery.test;

import java.util.Random;

public class ThreadLocalTest {
	
	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	private static ThreadLocal<MyThreadScopeData> y = new ThreadLocal<MyThreadScopeData>();
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + 
							"has put data : " + data);
					x.set(data);
					
//					MyThreadScopeData my = new MyThreadScopeData();
//					my.setAge(data);
//					my.setName("name " + data);
//					y.set(my);
					MyThreadScopeData.getThreadInstance().setName("name" + data);;
					MyThreadScopeData.getThreadInstance().setAge(data);;
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	static class A{
		public void get(){
			int data = x.get();
			
			System.out.println("A from " + Thread.currentThread().getName()
					+ "get data : " + data);
			
			MyThreadScopeData my = MyThreadScopeData.getThreadInstance();
			
			System.out.println("aname: " + my.getName() + "   age: " + my.getAge());
		}
	}
	static class B{
		public void get(){
			int data = x.get();
			System.out.println("B from " + Thread.currentThread().getName() + 
					 "get data : " + data);
			
			MyThreadScopeData my = MyThreadScopeData.getThreadInstance();
			
			System.out.println("bname: " + my.getName() + "   age: " + my.getAge());

		}
	}
}

class MyThreadScopeData{
	private MyThreadScopeData(){}
//	private static MyThreadScopeData instance = null;
	private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
	public static /*synchronized*/ MyThreadScopeData getThreadInstance(){
		MyThreadScopeData instance = map.get();
		if (instance == null) {
			instance = new MyThreadScopeData();
			map.set(instance);
		}
		return instance;
	}
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

