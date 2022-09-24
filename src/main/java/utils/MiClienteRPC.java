package utils;

import model.daoCurp;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import utils.MiServidor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class MiClienteRPC {
    public static void main(String [] args) throws XmlRpcException, MalformedURLException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1500"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        daoCurp dato= new daoCurp();
        String nombre = "", apellido1 = "", apellido2 = "", sexo = "", estado = "", año = "", mes = "", dia = "", curp = "", nal = "";
        Scanner n = new Scanner(System.in);
        Scanner a1 = new Scanner(System.in);
        Scanner a2 = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        Scanner e = new Scanner(System.in);
        Scanner a = new Scanner(System.in);
        Scanner m = new Scanner(System.in);
        Scanner d = new Scanner(System.in);
        Scanner na = new Scanner(System.in);
        Scanner r = new Scanner(System.in);
        int resp=0;
                System.out.println("¿Qué deseas hacer?");
                System.out.println("(Escribe 1 ó 2)");
                System.out.println("1.-Registrar usuario");
                System.out.println("2.-Consultar usuarios");
                resp = r.nextInt();


                switch (resp){
                    case 1:
                        System.out.println("Escribe el nombre o nombres de la persona");
                        nombre = n.nextLine();
                        System.out.println("Escribe el apellido paterno de la persona");
                        apellido1 = a1.nextLine();
                        System.out.println("Escribe el apellido materno de la persona");
                        apellido2 = a2.nextLine();
                        System.out.println("¿La persona es hombre ó mujer? (Escribe hombre o mujer)");
                        sexo = s.nextLine();
                        System.out.println("Escriba en que estado nació la persona");
                        estado = e.nextLine();
                        System.out.println("Escriba el año de nacimiento de la persona");
                        año = a.nextLine();
                        System.out.println("Escriba el mes de nacimiento de la persona");
                        mes = m.nextLine();
                        System.out.println("Escriba el día de nacimiento de la persona");
                        dia = d.nextLine();
                        System.out.println("Ingresa dos números aleatorios");
                        nal = na.nextLine();



                        String nSubCadena = nombre.substring(0,2);
                        String a1SubCadena = apellido1.substring(0,1);
                        String a2SubCadena = apellido2.substring(0,1);
                        String sSubCadena = sexo.substring(0,1);
                        String eSubCadena = estado.substring(0,2);
                        String aSubCadena = año.substring(2,4);
                        String mSubCadena = mes.substring(0,2);
                        String dSubCadena = dia.substring(0,2);
                        String aa1SubCadena = apellido1.substring(2,3);
                        String aa2SubCadena = apellido2.substring(2,3);
                        String nnSubCadena = nombre.substring(2,3);
                        curp = (nSubCadena+a1SubCadena+a2SubCadena+aSubCadena+mSubCadena+dSubCadena+sSubCadena+eSubCadena+aa1SubCadena+aa2SubCadena+nnSubCadena+nal).toUpperCase();
                        System.out.println("Su curp es: "+ curp +".");

                        Object[] resultado = {nombre, apellido1, apellido2, sexo, estado, año, dia, mes, curp};
                        boolean registro = dato.saveDatos (nombre, apellido1, apellido2, sexo, estado, año, dia, mes, curp);
                        break;
                    case 2:
                        daoCurp datos= new daoCurp();
                        System.out.println("Nombre|Apellido paterno|Apellido materno|sexo|Estado de nacimiento|año|día|mes|curp \n");
                        System.out.println(datos.showDatos());
                        break;
                    default:
                        break;


                }
        }
    }