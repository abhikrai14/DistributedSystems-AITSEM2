package example;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MapMessageListener implements MessageListener 
{
	public void onMessage(Message message)
	{
		System.out.println("Got here 1");
		if (message instanceof MapMessage)
		{
			MapMessage mapMessage = (MapMessage)message;
			System.out.println("Got here 2");
			try
			{
				System.out.println("Got here 3");
				String name = mapMessage.getString("Name");
				System.out.println("Name : " + name);
			}
			catch (JMSException e)
			{
				throw new RuntimeException(e);
			}
		}
		else
		{
			System.out.println("Invalid Message Received");
		}
	}
}