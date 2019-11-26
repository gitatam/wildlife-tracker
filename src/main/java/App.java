import dao.AnimalDao;
import dao.SightingDao;
import dao.Sql2oAnimalDao;
import dao.Sql2oSightingDao;
import model.Animal;
import model.Sighting;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
        Sql2o sql2o = new Sql2o(connectionString, "gitata", "password");
        AnimalDao animalDao = new Sql2oAnimalDao(sql2o);
        SightingDao sightingDao = new Sql2oSightingDao(sql2o);

        before((req, res) -> {
            if (req.cookie("username") != null) {
                req.attribute("username", req.cookie("username"));
            }
        });

        before("/animals", (req, res) -> {
            if (req.attribute("username") == null) {
                res.redirect("/");
                halt();
            }
        });

        before("/animals/:id", (req, res) -> {
            if (req.attribute("username") == null) {
                res.redirect("/");
                halt();
            }
        });

        before("/animals/:id/add-sighting", (req, res) -> {
            if (req.attribute("username") == null) {
                res.redirect("/");
                halt();
            }
        });

        get("/", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.attribute("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            String username = req.queryParams("username").toUpperCase();
            res.cookie("username", username);
            model.put("username", username);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("animals", animalDao.getAll());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Map<String, Object> model = new HashMap<>();
            model.put("animal", animalDao.getById(id));
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/:id/add-sighting", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Map<String, Object> model = new HashMap<>();
            model.put("animal", animalDao.getById(id));
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animals/:id/add-sighting", (req, res) -> {
            int animalId = Integer.parseInt(req.params("id"));
            String ranger = req.attribute("username");
            String age = req.queryParams("age");
            String health = req.queryParams("health");
            String location = req.queryParams("location");

            Sighting sighting = new Sighting(animalId, ranger, age, health, location);
            sighting.setAnimalId(animalId);
            sightingDao.add(sighting);
            res.redirect("/sightings");
            return null;
        }, new HandlebarsTemplateEngine());
    }
}
