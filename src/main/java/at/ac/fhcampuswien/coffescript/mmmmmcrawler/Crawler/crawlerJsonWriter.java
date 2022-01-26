package at.ac.fhcampuswien.coffescript.mmmmmcrawler.Crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * to write the JSON file
 */

public class crawlerJsonWriter {

    public static void tryMeOutJSON(HashSet<String> links, TreeSet<crawler> Manager1, TreeSet<crawler> Manager2) {
    //Erstellt ein Fenster mit einer Ja-Nein-Abfrage (ob man die Links speichern will) und öffnet bei Ja das Speicherfenster
    //Speichert die Links in ein JSON-File ab

        Object[] options = {"Ja", "Nein"}; //Optionen, die auf den Buttons erscheinen sollen
        String dir = System.getProperty("user.home"); //Wird für das Default-Directory im JFileChooser verwendet

        //Limitiert JFileChooser auf JSON-Dateien
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON-Files", "json");

        //Öffnet JFileChooser
        JFileChooser chooser = new JFileChooser(dir+"/Desktop");
        chooser.setFileFilter(filter);

        //Wandelt Links in geordnete JSON-Strings um
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(links);;
        ArrayList<String> list = new ArrayList<>(); //Liste für das Speichern von Sublinks

        //Werden benötigt, um über die TreeSets zu iterieren
        Iterator<crawler> iterator1 = Manager1.iterator();
        Iterator<crawler> iterator2 = Manager2.iterator();

        //Wandelt und fügt die Links aus den TreeSets in die ArrayList
        while(iterator1.hasNext() && iterator2.hasNext()) {
            list.add(gson.toJson(iterator1.next().getPageLinks()));
            list.add(gson.toJson(iterator2.next().getPageLinks()));
        }

        //ReturnValue wird benötigt, weil "Speichern" ein Integer-Wert ist
        int returnValue = chooser.showDialog(null, "Save"); //null, weil es kein übergeordnetes Fenster gibt, Save als Name für den Speicherbutton.

        //Wenn Speichern ausgewählt wurde, wird gespeichert
        if(returnValue == JFileChooser.APPROVE_OPTION) {

            //Speichert es als JSON-Datei
            try(FileWriter fileWriter = new FileWriter(chooser.getSelectedFile()+".json")) {
                fileWriter.write(jsonString);
                for(int j = 0; j < list.size(); j++) {
                    fileWriter.append(list.get(j) + System.lineSeparator());
                }
                fileWriter.flush();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void simpleSearchJSON(HashSet<String> links, TreeSet<crawler> Manager1) {
        //Erstellt ein Fenster mit einer Ja-Nein-Abfrage (ob man die Links speichern will) und öffnet bei Ja das Speicherfenster
        //Speichert die Links in ein JSON-File ab

        Object[] options = {"Ja", "Nein"}; //Optionen, die auf den Buttons erscheinen sollen
        String dir = System.getProperty("user.home"); //Wird für das Default-Directory im JFileChooser verwendet

        //Limitiert JFileChooser auf JSON-Dateien
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON-Files", "json");

        //Öffnet JFileChooser
        JFileChooser chooser = new JFileChooser(dir+"/Desktop");
        chooser.setFileFilter(filter);

        //Wandelt Links in geordnete JSON-Strings um
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(links);
        ArrayList<String> list = new ArrayList<>(); //Liste für das Speichern von Sublinks

        //Werden benötigt, um über die TreeSets zu iterieren
        Iterator<crawler> iterator1 = Manager1.iterator();

        //Wandelt in JSON um und fügt die Links aus dem TreeSet in die ArrayList
        while(iterator1.hasNext()) {
            list.add(gson.toJson(iterator1.next().getPageLinks()));
        }

        //ReturnValue wird benötigt, weil "Speichern" ein Integer-Wert ist
        int returnValue = chooser.showDialog(null, "Save"); //null, weil es kein übergeordnetes Fenster gibt, Save als Name für den Speicherbutton.

        //Wenn Speichern ausgewählt wurde, wird gespeichert
        if(returnValue == JFileChooser.APPROVE_OPTION) {

            //Speichert es als JSON-Datei
            try(FileWriter fileWriter = new FileWriter(chooser.getSelectedFile()+".json")) {
                fileWriter.write(jsonString + list);
                fileWriter.flush();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}