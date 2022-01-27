package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawler;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawlerJsonWriter;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.crawlerManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * for try out the crawler with his functions
 */

public class TryMeOutController {


    public Button tiefe1;
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
    protected void onTryMeOutCrawl() {
        ta.clear();
        this.data = new crawler("https://www.oft.at"); //BaseURL die gecrawled werden soll
        ta.setText(data.toString());
        Manager1 = null;
        Manager2 = null;
    }
    @FXML
    protected void tiefe1() {
        if(Manager1 == null){ //Es wird nur gecrawled wenn die Tiefe 1 noch nie gecrawled wurde oder das Baseobjekt sich nicht geändert hat.
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
    protected void tiefe2()  {
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
    public void SaveAsJSON() {
        if (data != null) {
            crawlerJsonWriter.tryMeOutJSON(data.getPageLinks(), Manager1.getContent(), Manager2.getContent());
        }
    }
    @FXML
    public void back(ActionEvent event) throws IOException {
        //navigation zurück zur Landing Page
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Landing Page");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}