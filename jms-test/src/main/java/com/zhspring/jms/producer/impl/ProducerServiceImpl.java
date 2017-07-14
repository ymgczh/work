package com.zhspring.jms.producer.impl;


import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import com.zhspring.jms.producer.ProducerService;

public class ProducerServiceImpl implements ProducerService{

	@Autowired
	JmsTemplate jmsTemplate;
	
	@Resource(name = "queueDestination")
	Destination distination;
	
	public void sendMessage(final String message) {
		//使用template发送消息
		jmsTemplate.send(distination, new MessageCreator() {
			//创建消息
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(message);
				System.out.println("发送消息：" + textMessage.getText());
				return textMessage;
			}
		});
	}

}
