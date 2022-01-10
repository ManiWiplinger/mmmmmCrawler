package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SimpleSearch extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SimpleSearch.class.getResource("simple-search.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 800);
        stage.setTitle("Landing Page");
        stage.setScene(scene);
        stage.show();
        }
        public static void main(String[] args) {
        launch();
        }
}