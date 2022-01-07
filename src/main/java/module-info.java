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
    requires json.smart;
    requires org.jsoup;

    opens at.ac.fhcampuswien.coffescript.mmmmmcrawler to javafx.fxml;
    exports at.ac.fhcampuswien.coffescript.mmmmmcrawler;
}