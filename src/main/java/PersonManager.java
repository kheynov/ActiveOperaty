import org.bson.Document;

public class PersonManager {
    private final DataBaseHandler dbHandler = new DataBaseHandler();

    public void addPerson(PersonModel person) {
        dbHandler.addPerson(person.getPersonDocument());
    }

    public PersonModel findPersonByCardID(int CardId) {
        Document document = dbHandler.getPersonByCardId(CardId);
        return new PersonModel(
                document.getString("name"),
                document.getInteger("age"),
                document.getInteger("ID"),
                document.getInteger("cardID"),
                document.getInteger("rating"));
    }

    public void deletePersonByCardID(int id) {
        dbHandler.deletePersonByCardId(id);
    }

    public void updatePerson(int cardId, String name, int age, int rating) {
        PersonModel person = new PersonModel(
                name,
                age,
                findPersonByCardID(cardId).getID(),
                cardId,
                rating
        );
        dbHandler.updatePersonByCardId(cardId, person.getPersonDocument());
    }
}
