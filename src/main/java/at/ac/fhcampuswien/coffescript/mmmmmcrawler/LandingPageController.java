package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LandingPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void goToTryMeOut(ActionEvent event) throws IOException {
        //navigation zum nächsten Fenster
        Parent root = FXMLLoader.load(getClass().getResource("app-view.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void goToSimpleSearch(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("simple-search.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goToSimpleSearchHeader(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("simple-search.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

    }
}