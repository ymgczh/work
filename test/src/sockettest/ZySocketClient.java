package sockettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * socket¿Í»§¶Ë
 * @author YMGC
 *
 */
public class ZySocketClient {
	
	private static int PORT = 8815;
	private static String ADDRESS = "127.0.0.1";
	
	public static void main(String[] args) {
		int size = 10;
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < size; i++) {
			service.execute(createTask(i));
		}
	}
	
	private static Runnable createTask(final int taskId){
		
		return new Runnable() {
			
			private Socket socket = null;
			
			@Override
			public void run() {
				System.out.println( " Task  "   +  taskId  +   " :start " );
				BufferedReader br = null;
				OutputStream out = null;
				try {
					socket = new Socket(ADDRESS, PORT);
					
					out = socket.getOutputStream();
					PrintWriter print = new PrintWriter(out);
					print.write("testtesttesttesttesttesttesttesttesttesttesttesttesttest,bye");
					print.flush();
					socket.shutdownOutput();
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String res = "";
					while ((res = br.readLine()) != null) {
						System.out.println(res);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						br.close();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}
}
