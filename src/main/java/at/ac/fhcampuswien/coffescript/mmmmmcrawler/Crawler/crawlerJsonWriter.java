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

    public static void toJsonToFileSaver(HashSet<String> links) {
    //Erstellt ein Fenster mit einer Ja-Nein-Abfrage (ob man die Links speichern will) und öffnet bei Ja das Speicherfenster

        Object[] options = {"Ja", "Nein"}; //Optionen, die auf den Buttons erscheinen sollen
        String dir = System.getProperty("user.home"); //Wird für das Default-Directory im JFileChooser verwendet

        //Fragt, ob die Links gespeichert werden sollen.
        if(JOptionPane.showOptionDialog(null, "Wollen Sie die gecrawlten Links speichern?", "Crawler",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {

            FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON-Files", "json"); //Limitiert JFileChooser auf JSON-Dateien

            JFileChooser chooser = new JFileChooser(dir+"/Desktop"); //Öffnet JFileChooser
            chooser.setFileFilter(filter); //Limitiert JFileChooser auf JSON-Dateien

            //Wandelt Links in geordnete JSON-Strings um
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = gson.toJson(links);

            //ReturnValue wird benötigt, weil "Speichern" ein Integer-Wert ist
            int returnValue = chooser.showDialog(null, "Save"); //null, weil kein übergeordnetes Fenster (oder noch keines), Save als Name für den Speicherbutton.

            //Wenn Speichern ausgewählt wurde, wird gespeichert
            if(returnValue == JFileChooser.APPROVE_OPTION) {

                try(FileWriter fileWriter = new FileWriter(chooser.getSelectedFile()+".json")) { //Speichert es als JSON-Datei
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