package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawler;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawlerJsonWriter;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawlerManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

/**this Class take Users input from TextField (whot should be a Link to a homepage and also alow the User to put a depth variable from 0-2
 *
 */
public class AdvancedSearchController  {

    public Button goToLandingPageButton;
    private crawlerManager[] Manager = new crawlerManager[3];

    @FXML
    TextArea ta2;

    @FXML
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField UserTextField1;
    @FXML
    private TextField DepthInput;
    private int depth;

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
        //navigation zurück zur Help Page
        Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("How To...");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void SearchFromUserTextField() {

        if (Objects.equals(UserTextField1.getText(), "")) {
            ta2.clear();
            ta2.setText("Bitte einen Link eingeben!");
        }
        else if (!DepthInput.getText().matches("[0-2]")) {
            ta2.clear();
            ta2.setText("Bitte Tiefe zwischen 0 - 2 eingeben");
        } else  {
            depth = Integer.parseInt(DepthInput.getText());
            ta2.clear();
            this.Manager[0] = new crawlerManager(new HashSet<String>(Collections.singleton("http://" + UserTextField1.getText())), 0);
            for (int i = 1; i <= depth; i++) {
                this.Manager[i] = new crawlerManager(this.Manager[i-1], i);
            }
            for (int i = 0; i <= depth; i++) {
                ta2.appendText(this.Manager[i].toString());
            }
        }
    }
}