import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class DataBaseHandler {
    private final MongoCollection<Document> collection;
    public DataBaseHandler() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(MONGO_URI.MONGO_URI));
        MongoDatabase mongoDatabase = mongoClient.getDatabase("data");
        collection = mongoDatabase.getCollection("persons");
    }
    public void addPerson(Document person){
        collection.insertOne(person);
    }
    public Document getPersonByCardId(int id){
        return collection.find(Filters.eq("cardID", id)).first();
    }
    public void updatePersonByCardId(int id, Document updatedPerson){
        collection.replaceOne(Filters.eq("cardID", id), updatedPerson);
    }
    public void deletePersonByCardId(int id){
        collection.deleteOne(Filters.eq("cardID", id));
    }
}
