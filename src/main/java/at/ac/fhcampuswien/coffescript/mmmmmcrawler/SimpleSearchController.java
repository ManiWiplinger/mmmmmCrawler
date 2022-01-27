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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;

/**
 * This Class take Users input from TextField (whot should be a Link to a homepage
 */

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

    @FXML
    public void goToLandingPage(ActionEvent event) throws IOException {
        //Navigation zurück zur Landing Page
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Landing Page");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void goToHelp(ActionEvent event) throws IOException {
        //Navigation zurück zur Help Page
        Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getIcons().add(new Image("file:src/main/resources/graphics/default-app-icon.png"));
        stage.setTitle("How To...");
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
            crawlerJsonWriter.simpleSearchJSON(data.getPageLinks(), Manager1.getContent());
        }
    }
}