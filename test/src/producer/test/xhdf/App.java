package producer.test.xhdf;

public class App {

	public static void main(String[] args) {
		
		Movie mv = new Movie();
		
		Player player = new Player(mv);
		Watcher wat = new Watcher(mv);
		
		for (int i = 0; i < 20; i++) {
			new Thread(player).start();
			new Thread(wat).start();
		}
	}

}
