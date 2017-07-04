package producer;

import java.util.Random;

public class Player implements Runnable{

	private Movie m;
	
	public Player(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			if (i % 2 ==0) {
				m.play("�ƻ�Ƭ" + Integer.toString(random.nextInt(100)) );
			} else {
				m.play("��¼Ƭ" + Integer.toString(random.nextInt(100)));
			}
		}
	}

	
}
