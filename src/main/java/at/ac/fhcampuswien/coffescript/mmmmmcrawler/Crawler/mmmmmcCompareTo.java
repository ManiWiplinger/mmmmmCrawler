package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import java.util.Comparator;

class mmmmmcCompareTo implements Comparator<mmmmmC> {
//TODO Override anpassen damit temp.add(test); in mmmmmcManager funktioniert
    @Override
    public int compare(mmmmmC a, mmmmmC b) {
        return a.getURL().compareTo(b.getURL());
    }
}
