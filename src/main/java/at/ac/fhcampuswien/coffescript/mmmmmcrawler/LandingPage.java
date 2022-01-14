package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;

public class LandingPage extends Application {
    @FXML
    private ImageView imageView;

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

