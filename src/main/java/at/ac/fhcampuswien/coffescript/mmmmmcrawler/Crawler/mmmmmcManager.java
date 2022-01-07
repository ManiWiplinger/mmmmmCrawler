package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class mmmmmcManager {
    private TreeSet<mmmmmC> content = new TreeSet<mmmmmC>();
    private int depth=0;

    public mmmmmcManager(HashSet<String> baseLinks, int depth) {
        this.depth = depth;
        this.content= nextDepthLinks(baseLinks);
    }

    public mmmmmcManager(mmmmmcManager baseManager, int depth) {
        this.depth = depth;
        HashSet<String> baseLinks = new HashSet<String>();
        for (mmmmmC out : baseManager.getContent()) {
            baseLinks.addAll(out.getPageLinks());
        }
        this.content= nextDepthLinks(baseLinks);
    }

    public int getDepth() {
        return depth;
    }

    public TreeSet<mmmmmC> getContent() {
        return content;
    }

    private TreeSet<mmmmmC> nextDepthLinks(HashSet<String> links){
        TreeSet<mmmmmC> temp = new TreeSet<mmmmmC>(new mmmmmcCompareTo());
        for(String URL : links){
            mmmmmC test= new mmmmmC(URL);
            //System.out.println(test.toString());
            //mmmmmcCompareTo muss funktionieren https://www.geeksforgeeks.org/how-to-sort-a-treeset-with-user-defined-objects-in-java/
            temp.add(test);
        }
        return temp;
    }

    @Override
    public String toString() {
        Iterator<mmmmmC> iterator = content.iterator();
        String output="Tiefe "+depth+":\n";
        while(iterator.hasNext()){
            mmmmmC temp = iterator.next();
            output = output.concat(temp.getURL()+"\n\t"+temp.toString().replaceAll("\n","\n\t"));
            output = output.concat("\n");
        }
        return output;
    }
}
