package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO����
 * @author YMGC
 *
 */
public class FileChannleTest {

	public static void main(String[] args) {
		String path = "C:"+File.separator+"����"+File.separator+"niotest.txt";
		try {
			//��ȡ�ļ�
			RandomAccessFile afile = new RandomAccessFile(path, "rw" );
			//�ļ��ܵ�
			FileChannel channel = afile.getChannel();
			//��������
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
				afile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
