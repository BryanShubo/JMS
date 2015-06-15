package JMS.listener;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Shubo on 6/15/2015.
 */

@Component
public class Consumer implements MessageListener{


    @Override
    public void onMessage(Message message) {
        System.out.println("In onMessage");
    }
}
