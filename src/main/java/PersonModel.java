import org.bson.Document;

public class PersonModel {
    private String name;
    private int age;
    private int ID;
    private int cardID;
    private int rating;
    private Document document;

    public PersonModel(String name, int age, int ID, int cardID, int rating) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.cardID = cardID;
        this.rating = rating;
        document = new Document();
        document.put("name", name);
        document.put("age", age);
        document.put("ID", ID);
        document.put("cardID", cardID);
        document.put("rating", rating);
    }

    public Document getPersonDocument() {
        return document;
    }

    public int getID() {
        return this.ID;
    }
}
