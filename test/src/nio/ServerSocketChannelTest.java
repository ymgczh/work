package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelTest {

	public static void main(String[] args) {
		ServerSocketChannel schannel = null;
		try {
			schannel = ServerSocketChannel.open();
			schannel.socket().bind(new InetSocketAddress(9999));
			while (true) {
				SocketChannel sochannel = schannel.accept();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			schannel.close();
		}
		
	}

}
