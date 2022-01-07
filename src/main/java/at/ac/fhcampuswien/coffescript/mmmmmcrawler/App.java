package at.ac.fhcampuswien.coffescript.mmmmmcrawler;

import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.mmmmmC;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.mmmmmcManager;
import at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler.mmmmmCJsonWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("App-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 800);
        stage.setTitle("mmmmmCrawler");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(); //Aufruf von AppController.java
        /* Für Test zwecke auskommentiert
        Scanner scan = new Scanner(System.in);
        System.out.print("Hallo, wonach soll ich für dich suchen?");
        String eingabe = scan.nextLine();
        System.out.print("Wie weit soll ich gehen?");
        int depth = scan.nextInt();
        mmmmmC data = new mmmmmC("http://www." + eingabe + ".at/");
        //System.out.println(data.toString());
        mmmmmcManager Manager = new mmmmmcManager(data.getPageLinks(), depth);

        //JSON part starts here
        mmmmmCJsonWriter.fileWriter(mmmmmCJsonWriter.hashSetConverter(data.getPageLinks()));
        //JSON part ends here
        for (mmmmmC out : Manager.getContent()) {
            System.out.println(out.getURL());
            System.out.println(out.toString());
        }
        */
    }
}