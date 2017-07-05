package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SimpleIo {

	public static void main(String[] args) throws IOException {
		String path = "C:" + File.separator + "工作" + File.separator + "niotest.txt";
		String opath = "C:" + File.separator + "工作" + File.separator + "oniotest.txt";
		File file = new File(path);
		try {
			InputStream in = new FileInputStream(file);
			OutputStream out = new FileOutputStream(opath);
			byte[] by = new byte[512];
			int len = -1;
			while ((len = in.read(by)) != -1) {
				out.write(by, 0, len);
			}
			out.close();
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
