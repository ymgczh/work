package producer.test.xhdf;

public class Player implements Runnable{
	
	private Movie mv;

	public Player(Movie mv) {
		super();
		this.mv = mv;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				mv.play("电影左青龙");
			} else {
				mv.play("电影碟中谍");
			}
		}		
	}
	
}
