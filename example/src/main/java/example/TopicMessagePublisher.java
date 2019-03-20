package example;

import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicMessagePublisher {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(TopicMessagePublisher.class);

  private String clientId;
  private Connection connection;
  private Session session;
  private MessageProducer messageProducer;

  public static void main(String[] args) throws URISyntaxException, Exception 
  {
	  
	  Connection connection = null;
		try
		{

    ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

	connection = cf.createConnection();
	
	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);


    // create a Connection
    connection = cf.createConnection();


    // create a Session
    session =
        connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

    // create the Topic to which messages will be sent
    Topic topic = session.createTopic("topic example");

    String text = "Paul Lennon";
  
  
    TextMessage textMessage = session.createTextMessage(text);
   
    // send the message to the topic destination
    MessageProducer messageProducer = session.createProducer(topic);
    messageProducer.send(textMessage);
    LOGGER.info(text); 
    connection.close();

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
		}
  }
}

  

