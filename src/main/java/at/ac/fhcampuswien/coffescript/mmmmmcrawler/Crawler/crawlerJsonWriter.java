package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
//import java.util.TreeSet;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class crawlerJsonWriter {

    HashSet<String> links;

    public crawlerJsonWriter(HashSet<String> links) {
        super();
        this.links = links;
    }

    /*public static void toJSONHash(HashSet<String> links) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(links);
        try(FileWriter toFile = new FileWriter("crawledLinks.json")) {
            toFile.write(jsonString);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void toJsonToFileSaver(HashSet<String> links) {
        //Erstellt ein Fenster mit einer Ja-Nein-Abfrage (ob man die Links speichern will) und öffnet bei Ja das Speicherfenster
        Object[] options = {"Ja", "Nein"};
        if(JOptionPane.showOptionDialog(null, "Wollen Sie die gecrawlten Links speichern?", "Crawler",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON-Files", "json");
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(filter);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = gson.toJson(links);

            int returnValue = chooser.showDialog(null, "Save"); //null, weil kein übergeordnetes Fenster (oder noch keines), Save als Name für den Speicherbutton.
            if(returnValue == JFileChooser.APPROVE_OPTION) {

                try(FileWriter fileWriter = new FileWriter(chooser.getSelectedFile()+".json")) {
                    fileWriter.write(jsonString);
                    fileWriter.flush();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*public static void toJSONTree(TreeSet set) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(set);
        try(FileWriter toFile = new FileWriter("crawledLinks.json")) {
            toFile.write(jsonString);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }*/
}