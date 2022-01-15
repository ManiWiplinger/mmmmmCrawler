package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import com.google.gson.*;
import com.google.gson.GsonBuilder;

public class crawlerJsonWriter {

    HashSet<String> links;

    public crawlerJsonWriter(HashSet<String> links) {
        super();
        this.links = links;
    }

    public static void toJSON(HashSet<String> links) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(links);
        try(FileWriter toFile = new FileWriter("crawledLinks.json")) {
            toFile.write(jsonString);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}