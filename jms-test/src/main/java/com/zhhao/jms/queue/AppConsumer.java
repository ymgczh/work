package com.zhhao.jms.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 队列模式消费者
 * @author YMGC
 *
 */
public class AppConsumer {
	
	private static final String url = "tcp://127.0.0.1:61616";
	private static final String queueName = "queue-test";

	public static void main(String[] args) throws JMSException {
		
		// 创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

		// 创建连接
		Connection connection = connectionFactory.createConnection();

		// 启动连接
		connection.start();

		// 创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// 创建目标
		Destination destination = session.createQueue(queueName);
		
		//创建消费者
		MessageConsumer consumer = session.createConsumer(destination);
		
		//消费者监听信息
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
				TextMessage text = (TextMessage) message;
				try {
					System.out.println("接收消息：" + text.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
