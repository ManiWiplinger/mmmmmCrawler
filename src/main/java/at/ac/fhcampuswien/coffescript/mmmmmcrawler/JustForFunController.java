package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawler;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawlerManager;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.joker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JustForFunController {

    @FXML
    private TextArea ta;
    private joker data = null;
    private String[] source = {"https://schlechtewitze.com/?sort=score", "https://schlechtewitze.com/flachwitze","https://schlechtewitze.com/perverse-flachwitze","https://schlechtewitze.com/informatiker",
            "https://schlechtewitze.com/chuck-norris", "https://schlechtewitze.com/deine-mutter", "https://schlechtewitze.com/", "https://schlechtewitze.com/zweideutige-witze", "https://schlechtewitze.com/kurze-witze",
            "https://schlechtewitze.com/kurze-witze?skip=40", "https://schlechtewitze.com/informatiker?skip=20", "https://schlechtewitze.com/informatiker?skip=40", "https://schlechtewitze.com/informatiker?skip=60",
    "https://schlechtewitze.com/informatiker?skip=80", "https://schlechtewitze.com/informatiker?skip=100","https://schlechtewitze.com/informatiker?skip=120","https://schlechtewitze.com/informatiker?skip=140", "https://schlechtewitze.com/informatiker?skip=160",
            "https://schlechtewitze.com/informatiker?skip=180", "https://schlechtewitze.com/?sort=score&skip=60", "https://schlechtewitze.com/?sort=score&skip=80", "https://schlechtewitze.com/?sort=score&skip=100"};

    private int randomNumber() {
        Random random = new Random();
        int randomJokeNumber = random.nextInt(this.source.length);
        return randomJokeNumber;
    }


    @FXML
    protected void onHelloButtonClick() {
        ta.clear();
        this.data = new joker(source[randomNumber()]); //BaseURL die gecrawld werden soll
        ta.setText(data.toString());
     }

    @FXML
    public void back(ActionEvent event) throws IOException {
        //navigation zurück zur Landing Page
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}