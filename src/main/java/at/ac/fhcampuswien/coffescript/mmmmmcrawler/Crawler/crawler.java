package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

public class crawler {
    private String URL=""; //URL die gecrawlt wird
    private HashSet<String> links = new HashSet<String>(); //Links die gefunden wurden, werden als String gespeichert

    public crawler(String URL) { //Konstruktor ruft den eigentlichen Crawler auf
        this.URL = URL;
        parseHTML();
    }

    private void parseHTML(){
        if (!links.contains(URL)){
            try {
                Document document = Jsoup.connect(URL).get();//.connect stellt die Verbindung her. .get fetcht den HTML code
                Elements linksOnPage = document.select("a[href]");//Das HTML Document wird nach Links zu anderen URLs geparst
                for (Element page : linksOnPage) {//alle URLs ins Hashset speichern
                    links.add(page.attr("abs:href"));//.attr extrahiert die URL aus dem HTML Element
                }
            } catch (IOException e) {
                System.err.println("For '"+ URL + "': " + e.getMessage());
            }
        }
    }

    public HashSet<String> getPageLinks() {
        return links;
    }
    public int getCountLinks() {
        return links.size();
    }
    public String getURL() {
        return URL;
    }

    @Override
    public String toString() { //Ausgabe
        TreeSet<String> temp= new TreeSet<String>(links); //Um die Links sortiert auszugeben wird das Hashset in ein Treeset umgewandelt
        StringBuilder out= new StringBuilder(); //aus den einzelnen Zeilen einen String machen
        int i=1;
        for(String tmp : temp){ //jeder gefundene Link wird dem Stringbuilder angehängt
            out.append("Link ").append(i).append(": ").append(tmp).append("\n"); // erzeugt den formatierten String mit allen gefundenen Links
            i++;
        }
        return out.toString();
    }
}
