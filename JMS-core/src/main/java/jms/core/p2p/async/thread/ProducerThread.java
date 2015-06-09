package jms.core.p2p.async.thread;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Shubo on 6/7/2015.
 */
public class ProducerThread implements Runnable{


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

            // create a MessageProducer from the session to the topic or queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // create a message
            String text = "Hello world from : " + Thread.currentThread().getName();
            TextMessage message = session.createTextMessage(text);

            // tell the producer to send the message
            System.out.println("Sent message: " +  message.hashCode() + " : " + Thread.currentThread().getName());
            producer.send(message);

            // clean up
            session.close();
            connection.close();

        } catch(Exception e) {

            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}
