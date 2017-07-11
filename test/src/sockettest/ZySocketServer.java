package sockettest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * socket多线程服务端
 * @author YMGC
 *
 */
public class ZySocketServer {

	private int port = 8815;
	private ExecutorService executorService;
	private ServerSocket serverSocket;
	private final int PORT_SIZE = 10;
	
	public ZySocketServer() throws IOException {
		super();
		// Runtime的availableProcessor()方法返回当前系统的CPU数目. 
		this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * PORT_SIZE);
		this.serverSocket = new ServerSocket(port);
		System.out.println("服务端启动");
	}
	
	public void service(){
		while (true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				executorService.execute(new Handler(socket));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new ZySocketServer().service();
	}
	
}












