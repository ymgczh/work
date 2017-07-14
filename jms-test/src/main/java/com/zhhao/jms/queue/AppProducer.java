package com.zhhao.jms.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 队列模式
 * @author YMGC
 *
 */
public class AppProducer {

	private static final String url = "tcp://127.0.0.1:61616";
	private static final String queueName = "queue-test";
	
	public static void main(String[] args) throws JMSException {
		
		//创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		//创建连接
		Connection connection = connectionFactory.createConnection();
		
		//启动连接
		connection.start();
		
		//创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		//创建目标
		Destination destination = session.createQueue(queueName);
		
		//创建生产者
		MessageProducer producer = session.createProducer(destination);
		
		for (int i = 0; i < 100; i++) {
			
			//创建消息
			TextMessage text = session.createTextMessage("test:" + i);
			
			//发送消息
			producer.send(text);
			
			System.out.println("发送消息：" + text.getText());
		}
		
		//关闭连接
		connection.close();
	}
}
