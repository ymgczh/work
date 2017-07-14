package com.zhspring.jms.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConsumer {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/consumer.xml");
	}
}
