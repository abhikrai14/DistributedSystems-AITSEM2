package example;
import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.log4j.Logger;

public class ObjectMessageSender 
{
	final static Logger logger = Logger.getLogger(ObjectMessageSender.class);
	
	public static void main(String[] args) throws URISyntaxException, Exception {
		//  Not using the embed ActiveMQ	
		//	BrokerService broker = BrokerFactory.createBroker(new URI(
		//		"broker:(tcp://localhost:61616)"));
		// broker.start();
		Connection connection = null;
		try
		{

			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

			connection = cf.createConnection();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("queue");
			
			MessageProducer messageProducer = session.createProducer(destination);
						
			MapMessage message = session.createMapMessage();
			
			book data = new book("Sending JMS", "John Doe", 2019);
			ObjectMessage myObject = session.createObjectMessage();
			myObject.setObject(data);
			messageProducer.send(myObject);
			logger.info("Sending message");
			
		
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (JMSException e)
				{
					System.out.println(e);
				} 
			}
			//Thread.sleep(20000);
			System.exit(0);
		}
		
	
	}
}