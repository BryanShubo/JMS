package JMS.adapter;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by Shubo on 6/15/2015.
 */
@Component
public class ConsumerAdapter {

    private static final Logger logger = LogManager.getLogger(ConsumerAdapter.class.getName());

    public void sendToMongo(String json) {

        try {
            logger.info("Sending to MongoDB");
            MongoClient client = new MongoClient();
            DB db = client.getDB("vendor");
            DBCollection collection = db.getCollection("contact");
            logger.info("Converting JSON to DBObject");
            DBObject object = (DBObject)JSON.parse(json);
            collection.insert(object);
            logger.info("Sent to MongoDB");
        } catch(Exception e) {

            e.printStackTrace();
        }


    }
}
