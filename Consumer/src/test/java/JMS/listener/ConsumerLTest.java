package JMS.listener;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by Shubo on 6/15/2015.
 */
public class ConsumerLTest {
    private TextMessage message;
    private ApplicationContext context;
    private ConsumerL listener;
    private  String json = "{vendorName:\"Microsoft\",firstName:\"Bob\",lastName:\"Smith\",address:\"12356 Main St\",city:\"Tulsa\",state:\"OK\",zip:\"71345\",email:\"Bob@microsoft.com\",phoneNumber:\"734-123-4567\"}";

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("spring/application-config.xml");
        listener = (ConsumerL)context.getBean("consumerL");
        message = createMock(TextMessage.class);
    }

    @After
    public void tearDown() {
        ((ConfigurableApplicationContext)context).close();
    }

    @Test
    public void onMessageTest() throws JMSException{
        expect(message.getText()).andReturn(json);
        replay(message);
        listener.onMessage(message);
        verify(message);
    }
}
