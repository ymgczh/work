package producer.test.xhdf;

/**
 * ��Ӱʵ����
 * @author Administrator
 *
 */
public class Movie {
	
	private String pic;
	
	private boolean flag = true;
	
	public synchronized void play(String pic){
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
		System.out.println("�����˵�Ӱ��" + pic);
		this.flag = false;
		this.pic = pic;
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
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("���˵�Ӱ��" + pic);
		this.flag = true;
		this.notify();
	}
}
