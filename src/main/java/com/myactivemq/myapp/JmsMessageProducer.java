package com.myactivemq.myapp;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageProducer {

	private static final Logger LOGGER = Logger
			.getLogger(JmsMessageProducer.class);
	
	@Resource
	MyActiveMQFactory activeMQFactory;

	public void dropMessage(String message) throws JMSException {
		LOGGER.info("In cutom message producer");
		MessageProducer producer = activeMQFactory.getMessageProducer();
		TextMessage textMessage = activeMQFactory.getTextMessage();
		textMessage.setText(message);
		producer.send(textMessage);
		LOGGER.info("message sent: " + message);
	}
}
