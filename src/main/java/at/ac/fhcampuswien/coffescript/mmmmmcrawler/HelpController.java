package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelpController {

    private Stage stage;
    private Scene scene;

    @FXML
    public void goToLandingPage(ActionEvent event) throws IOException {
        //Navigation zurück zur Landing Page
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Landing Page");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}