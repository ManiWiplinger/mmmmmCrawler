package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.mmmmmC;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.mmmmmCJsonWriter;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.mmmmmcManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class AppController {
    @FXML
    private Label baseCrawl;
    @FXML
    private TextArea ta;
    private final mmmmmC data = new mmmmmC("http://www.oft.at/"); //BaseURL die gecrawld werden soll
    private final mmmmmcManager Manager1 = new mmmmmcManager(data.getPageLinks(), 1);
    private final mmmmmcManager Manager2 = new mmmmmcManager(Manager1, 2);
    @FXML
    protected void onHelloButtonClick() {
        baseCrawl.setText(data.toString());
    }

    @FXML
    protected void tiefe1() {
        ta.clear();
        ta.setText(Manager1.toString());
    }

    @FXML
    protected void tiefe2() {
        ta.clear();
        ta.setText(Manager2.toString());
    }
}