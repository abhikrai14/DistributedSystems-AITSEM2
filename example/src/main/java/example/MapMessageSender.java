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

public class MapMessageSender 
{
	final static Logger logger = Logger.getLogger(MapMessageSender.class);
	
	public static void main(String[] args) throws URISyntaxException, Exception {
	//  Not using the embed ActiveMQ	
	//	BrokerService broker = BrokerFactory.createBroker(new URI(
		//		"broker:(tcp://localhost:61616)"));
		// broker.start();
		Connection connection = null;
		try
		{
			//Have ActiveMQ installed on the computer so using this instead of embeded version
			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

			connection = cf.createConnection();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("queue");
			
			MessageProducer messageProducer = session.createProducer(destination);
						
			MapMessage message = session.createMapMessage();
			
			message.setString("Name", "Tim");
			message.setString("Role", "Developer");
			message.setDouble("Salary", 850000);
			logger.info("Sending message");
			messageProducer.send(message);
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