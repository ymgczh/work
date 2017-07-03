package testclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class AliTest {

	public static void main(String[] args) throws IOException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.DATE, 1);
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime()));
		System.out.println(cal.getTimeInMillis());
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date());
		cal2.set(Calendar.HOUR_OF_DAY, 23);
		cal2.set(Calendar.MINUTE, 59);
		cal2.set(Calendar.SECOND, 59);
		cal2.set(Calendar.DATE, 5);
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal2.getTime()));
		
		System.out.println(cal2.getTimeInMillis());
		Long t = System.currentTimeMillis();
		System.out.println(t);
		if (t>cal2.getTimeInMillis() || t<cal.getTimeInMillis()) {
			System.out.println(1233121);
		}
		
		System.out.println(java.net.URLDecoder.decode("%E7%8E%8B%E5%8F%91%E9%BE%99","utf-8"));
	}
}
