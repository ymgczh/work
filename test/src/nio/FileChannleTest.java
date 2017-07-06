package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * NIO初涉
 * @author YMGC
 *
 */
public class FileChannleTest {

	public static void main(String[] args) {
		String path = "C:"+File.separator+"工作"+File.separator+"niotest.txt";
		try {
			//读取文件
			RandomAccessFile afile = new RandomAccessFile(path, "rw" );
			//文件管道
			FileChannel channel = afile.getChannel();
			//流缓冲区
			ByteBuffer bybr = ByteBuffer.allocate(48);
			
			try {
				int read = channel.read(bybr);
				while (-1 != read) {
					System.out.println("Read:" + read);
					bybr.flip();
					
					while (bybr.hasRemaining()) {
						System.out.print((char)bybr.get());
					}
					
					bybr.clear();
					read = channel.read(bybr);
				}
				
				bybr.clear();
				String init = "\r\n"+"写入随机数：" + new Random().nextInt(10000);
				bybr.put(init.getBytes());
				bybr.flip();
				while (bybr.hasRemaining()) {
					channel.write(bybr);
				}
				channel.close();
				afile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
