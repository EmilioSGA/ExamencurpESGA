package utils;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class MiServidor {
    public static void main(String [] args) throws XmlRpcException, IOException {
        System.out.println("Iniciando el server");
        PropertyHandlerMapping mapping = new PropertyHandlerMapping();
        mapping.addHandler("Funcion", Funciones.class);

        WebServer server= new WebServer(1500);
        server.getXmlRpcServer().setHandlerMapping(mapping);
        server.start();
        System.out.println("Esperando...");
    }
}
