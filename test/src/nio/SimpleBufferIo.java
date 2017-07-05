package nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class SimpleBufferIo {

	public static void main(String[] args) throws Exception {
		String path = "C:" + File.separator + "工作" + File.separator + "niotest.txt";
		String opath = "C:" + File.separator + "工作" + File.separator + "oniotest.txt";
		
		BufferedReader bur = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		char[] ca = new char[1024];
		String line = "";
		String res = "";
		while ((line = bur.readLine()) != null) {
			res += line;
		}
		System.out.println(res);
	}

}
