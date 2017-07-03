package testForEvery.test;

public class TranditionalThreadCommunication {

	public static void main(String[] args) {
		
		final Bussiness bus = new Bussiness();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int j = 1; j <= 50; j++) {
					bus.sub(j);
				}
			}
		}).start();
		
		for (int j = 1; j <= 50; j++) {
			bus.main(j);
		}
	}
}

class Bussiness {
	private boolean bShouldSub = true;
	public synchronized void sub(int i){
		if (!bShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (i = 1; i <= 10; i++) {
			System.out.println("子线程的循环次数：" + i + ",loop of " + i);
		}
		bShouldSub = false;
		this.notify();
	}
	public synchronized void main(int i){
		if (bShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (i=1; i <= 100; i++) {
			System.out.println("主线程的循环次数：" + i + ",loop of " + i);
		}
		bShouldSub = true;
		this.notify();
	}
}
