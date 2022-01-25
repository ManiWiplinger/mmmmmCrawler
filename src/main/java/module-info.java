module at.ac.fhcampuswien.coffescript.mmmmmcrawler {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires org.jsoup;
    requires java.desktop;
    requires com.google.gson;
    requires javafx.media;

    exports at.ac.fhcampuswien.coffescript.mmmmmcrawler;
    opens at.ac.fhcampuswien.coffescript.mmmmmcrawler to javafx.fxml;
}