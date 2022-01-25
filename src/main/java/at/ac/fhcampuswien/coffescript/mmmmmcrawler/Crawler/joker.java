package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashSet;

public class joker{
    private String URL=""; //URL die gecrawlt wird
    private LinkedHashSet<String> links = new LinkedHashSet<>(); //Links die gefunden wurden, werden als String gespeichert

    public joker(String URL) { //Konstruktor ruft den eigentlichen Crawler auf
        this.URL = URL;
        parseHTML();
    }

    private void parseHTML(){
        if (!links.contains(URL)){
            try {
                Document document = Jsoup.connect(URL).get();//.connect stellt die Verbindung her. .get fetcht den HTML code
                Elements linksOnPage = document.select("section");//Das HTML Document wird nach Links zu anderen URLs geparst
                for (Element page : linksOnPage) {//alle URLs ins Hashset speichern
                    links.add(page.text());//.attr extrahiert die URL aus dem HTML Element
                }
            } catch (IOException e) {
                System.err.println("For '"+ URL + "': " + e.getMessage());
            }
        }
    }

    public String toString() { //Ausgabe
        LinkedHashSet<String> temp= new LinkedHashSet<>(links); //Um die Witze sortiert auszugeben sortiert LinkedHashSet die Strings nach der gefundenen Reihenfolge
        StringBuilder out= new StringBuilder(); //aus den einzelnen Zeilen einen String machen
        int i=1;
        for(String tmp : temp){ //jeder gefundene Link wird dem Stringbuilder angehängt
            out.append("Witz ").append(i).append(": ").append(tmp).append("\n \n"); // erzeugt den formatierten String mit allen gefundenen Links
            i++;
        }
        return out.toString();
    }
}