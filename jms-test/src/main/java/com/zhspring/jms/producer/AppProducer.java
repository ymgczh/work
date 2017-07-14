package com.zhspring.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/producer.xml");
		ProducerService pro = context.getBean(ProducerService.class);
		for (int i = 0; i < 100; i++) {
			pro.sendMessage("TEST：" + i);
		}
		context.close();
	}
}
