package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class crawlerJsonWriter {

    public static void toJsonToFileSaver(HashSet<String> links) {
    //Erstellt ein Fenster mit einer Ja-Nein-Abfrage (ob man die Links speichern will) und öffnet bei Ja das Speicherfenster
    //Speichert die Links in ein JSON-File ab

        Object[] options = {"Ja", "Nein"}; //Optionen, die auf den Buttons erscheinen sollen
        String dir = System.getProperty("user.home"); //Wird für das Default-Directory im JFileChooser verwendet

        //Fragt, ob die Links gespeichert werden sollen.
        if(JOptionPane.showOptionDialog(null, "Wollen Sie die gecrawlten Links speichern?", "Crawler",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {

            //Limitiert JFileChooser auf JSON-Dateien
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON-Files", "json");

            //Öffnet JFileChooser
            JFileChooser chooser = new JFileChooser(dir+"/Desktop");
            chooser.setFileFilter(filter);

            //Wandelt Links in geordnete JSON-Strings um
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = gson.toJson(links);

            //ReturnValue wird benötigt, weil "Speichern" ein Integer-Wert ist
            int returnValue = chooser.showDialog(null, "Save"); //null, weil es kein übergeordnetes Fenster gibt, Save als Name für den Speicherbutton.

            //Wenn Speichern ausgewählt wurde, wird gespeichert
            if(returnValue == JFileChooser.APPROVE_OPTION) {

                //Speichert es als JSON-Datei
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