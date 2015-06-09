package jms.core.p2p.async.thread;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.beans.ExceptionListener;

/**
 * Created by Shubo on 6/7/2015.
 */
public class ConsumerThread implements Runnable, ExceptionListener{
    @Override
    public void run() {

        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            //create a connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // create a session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // create a destination
            Destination destination = session.createQueue("BryanThread.TestQ");

            // create a MessageConsumer from the session to the topic or queue
            MessageConsumer consumer = session.createConsumer(destination);

            // wait for a message
            Message message = consumer.receive(1000);

            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage)message;
                String text = textMessage.getText();
                System.out.println("Received: " + text);
            } else {
                System.out.println("Received = " + message);
            }

            consumer.close();
            session.close();
            connection.close();
        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void exceptionThrown(Exception e) {
        System.out.println("Caught: " + e);
    }
}
