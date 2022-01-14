package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LandingPage extends Application {

    java.net.URL url = ClassLoader.getSystemResource("src/main/resources/graphics/default-app-icon.png");

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LandingPage.class.getResource("landing-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Landing Page");
        stage.setScene(scene);
        stage.show();
        }
        public static void main(String[] args) {
        launch();
        }
    }

