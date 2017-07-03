package testclass;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {

	@Test
	public void test() throws InterruptedException {
//		Date time = new Date();
//		String ftime = new SimpleDateFormat("yyyyMMddHHmmss").format(time);
//		System.out.println(ftime);
		
		for (int i = 0; i < 10; i++) {
			
			System.out.println("1");
			Thread.currentThread().sleep(1000);
		}
	}

}
