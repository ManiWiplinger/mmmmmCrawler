package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LandingPageController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("use me");
    }
}