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


public class ObjectMessageReceiver 
{
	final static Logger logger = Logger.getLogger(ObjectMessageReceiver.class);
	
	public static void main(String[] args) throws URISyntaxException, Exception {
	//	BrokerService broker = BrokerFactory.createBroker(new URI(
	//			"broker:(tcp://localhost:61616)"));
	//	broker.start();
		Connection connection = null;
		try
		{
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					"tcp://localhost:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("queue");
			
			MessageConsumer consumer = session.createConsumer(destination);
			Message message = consumer.receive();

			if (message instanceof MapMessage) {
				MapMessage myMessage = (MapMessage) message;
				logger.info("Received '" + myMessage.getString(("Name"))+ "'"+ myMessage.getString(("Role"))
				+ "'"+ myMessage.getString(("Salary"))+ "'");
			}
			
			if (message instanceof ObjectMessage) {
				Object object = ((ObjectMessage) message).getObject();
				book myBook = (book) object;
				logger.info("here2");
				logger.info("Received '" + myBook.toString());
			}
			//consumer.setMessageListener(new MapMessageListener());
			logger.info("here3");
		
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
			System.exit(0);
		}
		
	
	}
}