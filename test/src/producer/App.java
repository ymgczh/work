package producer;

public class App {
	public static void main(String[] args) {
		//共同资源
		Movie m = new Movie();
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		for (int i = 0; i < 20; i++) {
			new Thread(p).start();
			new Thread(w).start();
		}
	}
}
