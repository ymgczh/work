package testclass;

import java.util.Calendar;
import java.util.Date;

public class MonthTest {

	public static void main(String[] args) {
		//获取当前时间
    	Date nowDate = new Date();
    	//获取三个月前的时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.add(Calendar.MONTH, -3);
		System.out.println("<?xml version='1.0' encoding='UTF-8'?>".length());
	}

}
