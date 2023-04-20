module springboot.javafx.support {
    requires java.datatransfer;
    requires java.desktop;
    requires javafx.controls;
    requires javafx.fxml;
    requires logback.classic;
    requires org.slf4j;
    requires spring.beans;
    requires spring.boot;
    requires spring.context;
    requires spring.core;

    exports de.felixroske.jfxsupport;
}