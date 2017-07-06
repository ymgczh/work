package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {

	public static void main(String[] args) {
		try {
			SocketChannel channel = SocketChannel.open();
			channel.connect(new InetSocketAddress("localhost", 8080));
			ByteBuffer bybr = ByteBuffer.allocate(48);
			channel.read(bybr);
			
			while (bybr.hasRemaining()) {
				bybr.get();
			}
			
			bybr.put("haha".getBytes());
			channel.write(bybr);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
