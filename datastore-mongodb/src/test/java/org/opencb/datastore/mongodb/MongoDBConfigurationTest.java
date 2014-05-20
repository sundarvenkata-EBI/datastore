package org.opencb.datastore.mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * Created by imedina on 25/03/14.
 * 
 * @author Ignacio Medina Castelo <imedina@ebi.ac.uk>
 * @author Cristina Yenyxe Gonzalez Garcia <cyenyxe@ebi.ac.uk>
 */
public class MongoDBConfigurationTest {

    @Test
    public void testInit() throws Exception {
        MongoDBConfiguration mongoDBConfiguration = MongoDBConfiguration.builder().init()
                .add("writeConcern", "ACK")
                .build();
        System.out.println(mongoDBConfiguration.toJson());

        MongoClient client = new MongoClient("localhost");
        DB db = client.getDB("test");

        MongoDataStore mongoDataStore = new MongoDataStore(client, db, mongoDBConfiguration);
        
        assertNotNull(mongoDataStore);
        assertEquals(db, mongoDataStore.getDb());
    }
}
