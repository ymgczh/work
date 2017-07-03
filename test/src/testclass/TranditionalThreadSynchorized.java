package testclass;

public class TranditionalThreadSynchorized {

	public static void main(String[] args) {
		new TranditionalThreadSynchorized().init();
	}
	
	private void init(){
	    Outputer out = new Outputer();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.output("zhanghao");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.output("yiming");
				}
			}
		}).start();
	}
	
	class Outputer{
		public synchronized void output(String name) {
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
		
		public void output2(String name) {
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}
