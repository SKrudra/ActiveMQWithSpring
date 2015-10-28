package com.myactivemq.myapp;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Component;

@Component
public class MyActiveMQFactory {
	@Resource(name = "jmsConnectionFactory")
	private ActiveMQConnectionFactory connectionFactory;
	@Resource(name = "myQueue")
	private ActiveMQQueue myQueue;

	private Session session;

	public MessageProducer getMessageProducer() throws JMSException {
		Connection connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		return session.createProducer(myQueue);
	}

	public TextMessage getTextMessage() throws JMSException {
		return session.createTextMessage();
	}
}
