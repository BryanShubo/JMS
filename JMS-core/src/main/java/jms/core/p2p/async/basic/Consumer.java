package jms.core.p2p.async.basic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Shubo on 6/7/2015.
 */
public class Consumer {

    public static void main(String[] args){

        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            //create a connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // create a session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // create a destination
            Destination destination = session.createQueue("Bryan.TestQ");

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
}
