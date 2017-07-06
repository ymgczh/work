package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 通道channle选择器
 * @author YMGC
 */
public class SelectorTest {

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) throws Exception {
		SocketChannel channel = SocketChannel.open();
		
		Selector selector = Selector.open();
		channel.configureBlocking(false);
		SelectionKey selkey = channel.register(selector, SelectionKey.OP_READ);
		while (true) {
			int readChannel = selector.select();
			if (readChannel == 0) {
				continue;
			}
			Set set = selector.selectedKeys();
			Iterator ite = set.iterator();
			while (ite.hasNext()) {
				SelectionKey key = (SelectionKey) ite.next();
				if (key.isReadable()) {
					System.out.println("老铁，你访问通了我的服务器");
				} else if (key.isConnectable()) {  
			        // a connection was established with a remote server.  
			    } else if (key.isReadable()) {  
			        // a channel is ready for reading  
			    } else if (key.isWritable()) {  
			        // a channel is ready for writing  
			    }  
			}
		}
	}

}
