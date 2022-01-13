package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class crawlerManager {
    private TreeSet<crawler> content = new TreeSet<crawler>();
    private int depth=0;

    public crawlerManager(HashSet<String> baseLinks, int depth) {
        this.depth = depth;
        this.content= nextDepthLinks(baseLinks);
    }

    public crawlerManager(crawlerManager baseManager, int depth) {
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

    private TreeSet<crawler> nextDepthLinks(HashSet<String> links){
        TreeSet<crawler> temp = new TreeSet<crawler>(new crawlerCompareTo());
        for(String URL : links){
            crawler test= new crawler(URL);
            //System.out.println(test.toString());
            //crawlerCompareTo muss funktionieren https://www.geeksforgeeks.org/how-to-sort-a-treeset-with-user-defined-objects-in-java/
            temp.add(test);
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
