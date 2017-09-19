import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import org.bson.Document;
import com.mongodb.*;

public class MongoExample {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        DB database = mongoClient.getDB("Customers");
        DBCollection coll = database.getCollection("Special");

        // print existing databases
        mongoClient.getDatabaseNames().forEach(System.out::println);

        //database.createCollection("customers", null);

        // print all collections in customers database
        database.getCollectionNames().forEach(System.out::println);

        // create data
        /*DBCollection collection = database.getCollection("customers");
        BasicDBObject newDocument1 = new BasicDBObject();
        newDocument1.put("name", "John");
        newDocument1.put("company", "Baeldung");
        WriteConcern wc = new WriteConcern();
        collection.insert(newDocument1,wc);*/
        
     // read data
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "Sam");
        DBCursor cursor = coll.find(searchQuery);
        while (cursor.hasNext()) {
            System.out.println("1st time : reading data :  "+cursor.next());
        }
     
        
        // update data
       /* BasicDBObject query = new BasicDBObject();
        query.put("name", "Shubham");
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "John");
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);
        collection.update(query, updateObject);

        // read data
        BasicDBObject searchQuery1 = new BasicDBObject();
        searchQuery1.put("name", "Shubham");
        DBCursor cursor1 = collection.find(searchQuery1);
        while (cursor.hasNext()) {
            System.out.println("2nd time, reading data :  "+cursor1.next());
        }*/

        // delete data
        /*BasicDBObject deleteQuery = new BasicDBObject();
        deleteQuery.put("name", "John");
        collection.remove(deleteQuery);*/
    }
}
