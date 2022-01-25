package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawler;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawlerManager;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawlerJsonWriter;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;


public class SimpleSearchController {
    private crawler data = null;
    private crawlerManager Manager1 = null;

    @FXML
    TextArea ta1;

    @FXML
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField UserTextField;

    //TODO: HeaderBar Navigation
    @FXML
    public void goToLandingPage(ActionEvent event) throws IOException {
        //Navigation zurück zur Landing Page
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void goToHelp(ActionEvent event) throws IOException {
        //navigation zurück zur Help Page
        Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void SearchFromUserTextField() throws IOException {

        if (UserTextField.getText() == "") {
            ta1.setText("Bitte einen Link eingeben!");
        } else {

            this.data = new crawler("http://" + UserTextField.getText());
            this.Manager1 = new crawlerManager(data.getPageLinks(), 1);
            ta1.clear();
            ta1.setText(Manager1.toString());

        }
    }

    @FXML
    public void SaveAsJSON(ActionEvent SaveAsJSON) throws IOException{
        if (data != null) {
            crawlerJsonWriter.toJsonToFileSaver(data.getPageLinks());
        }

    }

        //crawlerJsonWriter test = new crawlerJsonWriter(/*data.getPageLinks()*/);
        //test.start();
        //Implementierung der Json-Funktion + Speichern in ein File (funktioniert)

        //TODO! öffnen in neuer Seite nicht funktional, error meldung mit "ta1 is null"
        /*Parent root = FXMLLoader.load(getClass().getResource("crawler-results.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 350, 350));
        stage.setScene(scene);
        stage.show();*/
}


