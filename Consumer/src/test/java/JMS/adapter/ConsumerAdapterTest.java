package JMS.adapter;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Shubo on 6/16/2015.
 */
public class ConsumerAdapterTest {

    private  String json = "{vendorName:\"Microsoft\",firstName:\"Bob\",lastName:\"Smith\",address:\"123 Main St\",city:\"Tulsa\",state:\"OK\",zip:\"71345\",email:\"Bob@microsoft.com\",phoneNumber:\"734-123-4567\"}";

    @Test
    public void sendToMongoTest () {

        ConsumerAdapter consumerAdapter = new ConsumerAdapter();
        consumerAdapter.sendToMongo(json);
        assertNotNull(json);
    }
}
