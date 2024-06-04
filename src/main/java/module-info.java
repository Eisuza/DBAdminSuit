module com.ivs.dbnavigator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;
    //requires com.almasb.fxgl.all;
    requires java.sql;
    requires org.json;

    opens com.ivs.dbadminsuite to javafx.fxml;
    //exports com.ivs.dbadminsuite;
    exports com.ivs.dbadminsuite.config;
    opens com.ivs.dbadminsuite.config to javafx.fxml;
    exports com.ivs.dbadminsuite.dbmodifier;
    opens com.ivs.dbadminsuite.dbmodifier to javafx.fxml;
    exports com.ivs.dbadminsuite.dbvisualizer;
    opens com.ivs.dbadminsuite.dbvisualizer to javafx.fxml;
    exports com.ivs.dbadminsuite.main;
    opens com.ivs.dbadminsuite.main to javafx.fxml;
    exports com.ivs.dbadminsuite.qexecutor;
    opens com.ivs.dbadminsuite.qexecutor to javafx.fxml;
    exports com.ivs.dbadminsuite.db;
    opens com.ivs.dbadminsuite.db to javafx.fxml;
    exports com.ivs.dbadminsuite.umanagment;
    opens com.ivs.dbadminsuite.umanagment to javafx.fxml;
    exports com.ivs.dbadminsuite.statistics;
    opens com.ivs.dbadminsuite.statistics to javafx.fxml;
    exports com.ivs.dbadminsuite.errorhandler;
    opens com.ivs.dbadminsuite.errorhandler to javafx.fxml;
}