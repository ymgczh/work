package testclass;

import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {

	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("timer Taks");
				new Timer().schedule(this,1000);
			}
		}, 1000);
		while (true) {
			System.out.println(System.currentTimeMillis());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catdDDDch block
				e.printStackTrace();
			}
		}
	}

}
