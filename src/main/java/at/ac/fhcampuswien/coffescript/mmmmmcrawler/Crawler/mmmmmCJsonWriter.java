package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import net.minidev.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class mmmmmCJsonWriter {

    private HashSet toConvertToJSON;

    public mmmmmCJsonWriter(HashSet toConvertToJSON) {
        this.toConvertToJSON = toConvertToJSON;
    }

    public static JSONObject hashSetConverter(HashSet toConvertToJSON) {
        JSONObject writeToFile = new JSONObject();
        writeToFile.put("Links:", toConvertToJSON);
        return writeToFile;
    }
    public static void fileWriter(JSONObject writeToFile) {

        try (FileWriter file = new FileWriter("crawledLinks.json")) {
            file.write(writeToFile.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
