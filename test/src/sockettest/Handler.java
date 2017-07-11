package sockettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * socket¥¶¿Ì¿‡
 * @author YMGC
 *
 */
public class Handler implements Runnable{
	
	private Socket socket;

	public Handler(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println( " New connection accepted  " + socket.getInetAddress() + ":" + socket.getPort());
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			String msg = "";
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
				pw.print(" echo: " + msg);
				if (msg.equals("bye")) {
					break;
				}
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
