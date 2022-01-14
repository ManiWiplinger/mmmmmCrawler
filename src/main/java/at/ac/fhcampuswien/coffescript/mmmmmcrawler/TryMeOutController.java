package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawler;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawlerManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class TryMeOutController {
    @FXML
    private Label baseCrawl;
    @FXML
    private TextArea ta;
    private crawler data = null;
    private crawlerManager Manager1 = null;
    private crawlerManager Manager2 = null;
    @FXML
    private java.awt.Label UserTextField;

    @FXML
    protected void onHelloButtonClick() {

        this.data = new crawler("http://www.oft.at/"); //BaseURL die gecrawld werden soll
        baseCrawl.setText(data.toString());
        Manager1 = null;
        Manager2 = null;
    }

    @FXML
    protected void tiefe1() {
        if(Manager1 == null){
            if(data != null) {
                this.Manager1 = new crawlerManager(data.getPageLinks(), 1);
                ta.clear();
                ta.setText(Manager1.toString());
            }
            else
            {
                ta.clear();
                ta.setText("Fehler es muss zuerst Tiefe 0 gecrawled werden!");
            }
        }
        else{
            ta.clear();
            ta.setText(Manager1.toString());
        }
    }

    @FXML
    protected void tiefe2() {
        if(Manager2 == null){
            if(Manager1 != null) {
                this.Manager2 = new crawlerManager(Manager1, 2);
                ta.clear();
                ta.setText(Manager2.toString());
            }
            else
            {
                ta.clear();
                ta.setText("Fehler es muss zuerst Tiefe 1 gecrawled werden!");
            }
        }
        else{
            ta.clear();
            ta.setText(Manager2.toString());
        }
    }
    @FXML
    public void back(ActionEvent event) throws IOException {
        //navigation zum zurück zur Landing Page
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}