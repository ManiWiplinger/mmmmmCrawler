package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import java.util.Comparator;

class crawlerCompareTo implements Comparator<crawler> {

    @Override
    public int compare(crawler a, crawler b) {
        return a.getURL().compareTo(b.getURL());
    }
}