package testForEvery.test;

public class MultiThreadShareData {

	public static void main(String[] args) {
		final ShareData1 s1 = new ShareData1();
		
		new Thread(new MyRunable1(s1)).start();
		new Thread(new MyRunable2(s1)).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				s1.decrement();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				s1.increment();
			}
		}).start();
	}

}

class MyRunable1 implements Runnable{
	private ShareData1 data1;
	
	public MyRunable1(ShareData1 data1) {
		this.data1 = data1;
	}

	@Override
	public void run() {
		data1.decrement();
	}
}
class MyRunable2 implements Runnable{
	private ShareData1 data1;
	
	public MyRunable2(ShareData1 data1) {
		this.data1 = data1;
	}

	@Override
	public void run() {
		data1.increment();
	}
}

class ShareData1 {
	
	private int j = 0;
	public synchronized void increment(){
		j ++;
	}
	public synchronized void decrement(){
		j --;
	}
//	private int count = 100;
//	@Override
//	public void run() {
//		while (true) {
//			count --;
//		}
//	}
}