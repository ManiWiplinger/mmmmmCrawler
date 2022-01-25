package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class crawlerManager {
    private TreeSet<crawler> content = new TreeSet<crawler>();
    private int depth = 0;

    public crawlerManager(HashSet<String> baseLinks, int depth) { //Konstruktor für Tiefe null
        this.depth = depth;
        this.content = nextDepthLinks(baseLinks);
    }

    public crawlerManager(crawlerManager baseManager, int depth)  { // Konstruktor für Tiefen > 0
        this.depth = depth;
        HashSet<String> baseLinks = new HashSet<String>();
        for (crawler out : baseManager.getContent()) {
            baseLinks.addAll(out.getPageLinks());
        }
        this.content= nextDepthLinks(baseLinks);
    }

    public int getDepth() {
        return depth;
    }

    public TreeSet<crawler> getContent() {
        return content;
    }

    protected TreeSet<crawler> nextDepthLinks(HashSet<String> links){ // erzeugt mit den Links des übergebenen Hashset ein Teeset aus crawler Objekten
        TreeSet<crawler> temp = new TreeSet<crawler>(new crawlerCompareTo());
        for(String URL : links){
            crawler test= new crawler(URL);//Neues Crawl Objekt wird erstellt
            temp.add(test); // Crawl Objekt wird dem Treeset hinzugefügt (Sortierung nach baseURL)
        }
        return temp;
    }

    @Override
    public String toString() {
        Iterator<crawler> iterator = content.iterator();
        String output="Tiefe "+depth+":\n";
        while(iterator.hasNext()){
            crawler temp = iterator.next();
            output = output.concat(temp.getURL()+"\n\t"+temp.toString().replaceAll("\n","\n\t"));
            output = output.concat("\n");
        }
        return output;
    }
}
