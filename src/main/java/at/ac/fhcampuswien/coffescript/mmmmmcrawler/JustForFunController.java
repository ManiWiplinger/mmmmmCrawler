package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.joker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class JustForFunController {
    public CheckBox soundEffectChoice;
    public Button jokes;
    String path = "src//main//resources//soundeffect//KaffeemaschinenSoundHardBase.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    boolean soundMachine;

    @FXML
    private TextArea ta;
    private joker data = null;
    private String[] source = {"https://schlechtewitze.com/?sort=score", "https://schlechtewitze.com/flachwitze","https://schlechtewitze.com/perverse-flachwitze","https://schlechtewitze.com/informatiker",
            "https://schlechtewitze.com/chuck-norris", "https://schlechtewitze.com/deine-mutter", "https://schlechtewitze.com/", "https://schlechtewitze.com/zweideutige-witze", "https://schlechtewitze.com/kurze-witze",
            "https://schlechtewitze.com/kurze-witze?skip=40", "https://schlechtewitze.com/informatiker?skip=20", "https://schlechtewitze.com/informatiker?skip=40", "https://schlechtewitze.com/informatiker?skip=60",
            "https://schlechtewitze.com/informatiker?skip=80", "https://schlechtewitze.com/informatiker?skip=100","https://schlechtewitze.com/informatiker?skip=120","https://schlechtewitze.com/informatiker?skip=140", "https://schlechtewitze.com/informatiker?skip=160",
            "https://schlechtewitze.com/informatiker?skip=180", "https://schlechtewitze.com/?sort=score&skip=60", "https://schlechtewitze.com/?sort=score&skip=80", "https://schlechtewitze.com/?sort=score&skip=100", "https://schlechtewitze.com/scherzfragen"};

    private int randomNumber() { // generiert die Aurray Nummer von den Witzen die ausgegeben werden sollen
        Random random = new Random();
        int randomJokeNumber = random.nextInt(this.source.length);
        return randomJokeNumber;
    }

    @FXML
    protected void soundEffectsOn() {
        soundMachine = soundEffectChoice.isSelected();
    }
    @FXML
    protected void onSearchForFun() {
        if (soundEffectChoice.isSelected()) { //Soundeffect Checkbox wird aktiviert
            mediaPlayer.play();
            mediaPlayer.seek(Duration.ONE);
        }
        if (!soundEffectChoice.isSelected()){ //deaktivert den Sound wenn, das Häckchen wieder weggegeben wird
            mediaPlayer.stop();
        }
        ta.clear();
        this.data = new joker(source[randomNumber()]); //Witze die Ausgegeben werden sollen
        ta.setText(data.toString());
     }

    @FXML
    public void goToLandingPage(ActionEvent event) throws IOException {
        //navigation zurück zur Landing Page
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getIcons().add(new Image("file:src/main/resources/graphics/default-app-icon.png"));
        stage.setTitle("Landing Page");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void goToHelp(ActionEvent event) throws IOException {
        //navigation zurück zur Help Page
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
        stage.getIcons().add(new Image("file:src/main/resources/graphics/default-app-icon.png"));
        stage.setTitle("How To...");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}