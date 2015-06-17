package JMS.listener;

import JMS.adapter.ConsumerAdapter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.JMSException;

@Component
public class ConsumerL implements MessageListener {

    private static final Logger logger = LogManager.getLogger(ConsumerL.class.getName());

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ConsumerAdapter consumerAdapter;


    @Override
    public void onMessage(Message message) {

        logger.info("In onMessage");

        String json = null;
        if (message instanceof TextMessage) {
            try {
                json = ((TextMessage) message).getText();
                logger.info("Sending JSON to DB: " + json);
                consumerAdapter.sendToMongo(json);
            } catch (Exception e) {

                logger.error("Message: " + json);
                jmsTemplate.convertAndSend(json);
            }

        }
    }
}
