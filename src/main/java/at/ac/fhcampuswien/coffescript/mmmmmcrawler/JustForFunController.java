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
import java.util.ArrayList;
import java.util.List;

public class JustForFunController {

    @FXML
    private TextArea ta;
    private joker data = null;


    @FXML
    protected void onHelloButtonClick() {
        ta.clear();
        this.data = new joker("https://schlechtewitze.com/?sort=score"); //BaseURL die gecrawld werden soll
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