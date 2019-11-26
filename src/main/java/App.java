import dao.AnimalDao;
import dao.SightingDao;
import dao.Sql2oAnimalDao;
import dao.Sql2oSightingDao;
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

        before((req, res) ->{
            if (req.cookie("username") != null) {
                req.attribute("username", req.cookie("username"));
            }
        } );

        before("/animals", (req, res) -> {
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
            String username =  req.queryParams("username").toUpperCase();
            res.cookie("username", username);
            model.put("username", username);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("animals", animalDao.getAll());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
