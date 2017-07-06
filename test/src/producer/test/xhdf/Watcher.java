package producer.test.xhdf;

public class Watcher implements Runnable{

	private Movie mv;

	public Watcher(Movie mv) {
		super();
		this.mv = mv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			mv.watch();
		}
	}
}
