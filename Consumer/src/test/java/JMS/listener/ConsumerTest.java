package JMS.listener;

import org.junit.Test;
import static org.junit.Assert.*;
import javax.jms.TextMessage;

/**
 * Created by Shubo on 6/15/2015.
 */
public class ConsumerTest {
    private TextMessage message;

    @Test
    public void onMessageTest() {
        Consumer consumer = new Consumer();
        consumer.onMessage(message);
        assertNull(message);
    }
}
