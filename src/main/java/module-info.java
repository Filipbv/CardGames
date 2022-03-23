module no.ntnu.filipbv.cardgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens no.ntnu.filipbv.cardgame to javafx.fxml;
    exports no.ntnu.filipbv.cardgame;
}