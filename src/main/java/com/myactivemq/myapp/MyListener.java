package com.myactivemq.myapp;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements MessageListener {

	private static final Logger LOGGER = Logger.getLogger(MyListener.class);
	@Override
	public void onMessage(Message message) {
		// TODO: we can use the message as per requirements e.g. store into DB, generated report etc.

		LOGGER.info("in the listener"); 
		try {
			LOGGER.info(((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	
}
