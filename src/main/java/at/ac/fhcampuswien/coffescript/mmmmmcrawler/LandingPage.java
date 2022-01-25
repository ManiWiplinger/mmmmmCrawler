package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class LandingPage extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LandingPage.class.getResource("landing-page.fxml"));
        stage.getIcons().add(new Image("file:src/main/resources/graphics/default-app-icon.png"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Landing Page");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        }
    public static void main(String[] args) {

        launch();

    }

    }

