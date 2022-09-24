module mx.edu.utez.curps {

    requires xmlrpc.common;
    requires xmlrpc.client;
    requires xmlrpc.server;
    requires java.sql;
    requires mysql.connector.java;

    opens mx.edu.utez.curps to javafx.fxml;
    exports mx.edu.utez.curps;
}