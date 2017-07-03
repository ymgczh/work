package testclass;

public class ThreadTest {
	public static void main(String[] args) {
		Thread t = new Thread(){
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(this.getName());
				}
			}
		};
		t.start();
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t2.start();
		
		new Thread(){
			public void run() {
				while (true) {
					System.out.println(Thread.currentThread().getName());
				}
			};
		}.start();
	}

}
