package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class LandingPageController {

    java.net.URL url = ClassLoader.getSystemResource("src/main/resources/graphics/default-app-icon.png");

    private Stage stage;
    private Scene scene;
    private Parent root;

    //TODO: HeaderBar Navigation
    //TODO: Safe in Json
    @FXML
    private ImageView imageView;

    @FXML
    public void goToTryMeOut(ActionEvent event) throws IOException {
        //Navigation zum nächsten Fenster
        Parent root = FXMLLoader.load(getClass().getResource("try-me-out.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Try Me Out");
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void goToSimpleSearch(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("simple-search.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simple Search");
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void goToHelp(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("How To...");
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void goToSimpleSearchHeader(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("simple-search.fxml"));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    //TODO Header Close
    public void HeaderExitCrawler(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.close();
    }
}