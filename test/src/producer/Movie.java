package producer;

/**
 * ��ͬ��Դ
 * @author YMGC
 *
 */
public class Movie {
	
	private boolean flag = true;
	private String pic;
	
	public synchronized void play(String pic) {
		while (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "�����ˣ�" + pic);
		this.pic = pic;
		flag = false;
		this.notify();
	} 
	
	public synchronized void watch(){
		while (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "�����ˣ�" + pic);
		flag = true;
		this.notify();
	}
}
