package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.awt.Toolkit;

public class LandingPage extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LandingPage.class.getResource("landing-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Landing Page");
        stage.setScene(scene);
        stage.setResizable(false);
        //TODO default icon
        //Toolkit.getDefaultToolkit().getImage(LandingPage.class.getResource("default-app-icon.png"));
        stage.show();
        }
        public static void main(String[] args) {
        launch();
        }
    }

