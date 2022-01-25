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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;


public class AdvancedSearchController  {

    public Button goToLandingPageButton;
    private crawler data = null;
    private crawlerManager Manager1 = null;
    private TreeSet<crawler> content = new TreeSet<crawler>();

    @FXML
    TextArea ta2;

    @FXML
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField UserTextField;
    @FXML
    private TextField DepthInput;
    private int depth;


    @FXML
    public void goToLandingPage(ActionEvent event) throws IOException {
        //Navigation zurück zur Landing Page
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void goToHelp(ActionEvent event) throws IOException {
        //navigation zurück zur Help Page
        Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    /*public AdvancedSearchController(crawlerManager baseManager, int depth, TextField depthInput) {
        super(baseManager, depth);
        this.depth = depth;
        HashSet<String> baseLinks = new HashSet<String>();
        for (crawler out : baseManager.getContent()) {
            baseLinks.addAll(out.getPageLinks());
        }
        this.content= nextDepthLinks(baseLinks);
    }*/


    @FXML
    public void SearchFromUserTextField() {

        this.depth = Integer.parseInt(DepthInput.getText());

        if (UserTextField.getText() == "") {
            ta2.setText("Bitte einen Link eingeben!");
        }
        else if (this.depth < 0 || this.depth > 3) {
                ta2.setText("Bitte Tiefe zwischen 0 - 2 eingeben");
            } else  {

                this.data = new crawler("http://" + UserTextField.getText());
                this.Manager1 = new crawlerManager(data.getPageLinks(), 1);
                ta2.clear();
                ta2.setText(Manager1.toString());
            }
        /*@FXML
        public void SaveAsJSON(ActionEvent SaveAsJSON) throws IOException{
            if (data != null) {
                crawlerJsonWriter.toJsonToFileSaver(data.getPageLinks());
            }*/
        }


}

    


