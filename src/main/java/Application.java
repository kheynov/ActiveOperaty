import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        PersonManager personManager = new PersonManager();
        get("/getPerson/:cardId", (req, res) -> {
            try {
                return personManager.findPersonByCardID(Integer.parseInt(req.params(":cardId")))
                        .getPersonDocument()
                        .toJson();
            } catch (Exception e) {
                return "ERROR";
            }
        });
        get("/updatePerson/:cardId/:name/:age/:rating", (req, res) -> {
            try {
                personManager.updatePerson(
                        Integer.parseInt(req.params(":cardId")),
                        req.params(":name"),
                        Integer.parseInt(req.params(":age")),
                        Integer.parseInt(req.params(":rating")));
                return "OK";
            } catch (Exception e) {
                return "ERROR";
            }
        });
        get("/registerPerson/:name/:age/:rating/:cardId/:id", (req, res) -> {
            try {
                personManager.addPerson(new PersonModel(
                        req.params(":name"),
                        Integer.parseInt(req.params(":age")),
                        Integer.parseInt(req.params(":id")),
                        Integer.parseInt(req.params("cardId")),
                        Integer.parseInt(req.params(":rating"))));
                return "OK";
            } catch (Exception e) {
                return "ERROR";
            }
        });
        get("/deletePerson/:cardId", (req, res) -> {
            try {
                personManager.deletePersonByCardID(Integer.parseInt(req.params(":cardId")));
                return "OK";
            } catch (Exception e) {
                return "ERROR";
            }
        });
    }
}
