package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannlTransFormTest {

	public static void main(String[] args) throws IOException {
		String path = "C:" + File.separator + "工作" + File.separator + "niotest.txt";
		String opath = "C:" + File.separator + "工作" + File.separator + "oniotest.txt";
		
		try {
			RandomAccessFile f1 = new RandomAccessFile(path, "rw");
			RandomAccessFile f2 = new RandomAccessFile(opath, "rw");
			
			FileChannel ch1 = f1.getChannel();
			FileChannel ch2 = f2.getChannel();
			
			long position = 0;
			long size = ch1.size();
			
			ch2.transferFrom(ch1, position, size);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
