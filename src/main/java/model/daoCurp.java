package model;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoCurp<E> {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    private final String GET_DATOS = "SELECT * FROM curps WHERE curp = curp";

    private final String INSERT_DATOS = "INSERT INTO curps (nombre, apellido1, apellido2, sexo, estado, año, dia, mes, curp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public ArrayList<Object> showDatos (){
        ArrayList<Object> personList = new ArrayList<>();
        Object[] datos ;
        try{
            conn = new MySQLConnection().getConnection();
            String query = GET_DATOS;
            pstm = conn.prepareStatement(query);
            // pstm = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS); con esta linea obtenemos el id que tiene esa sentencia
            rs = pstm.executeQuery();
            //rs= pstm.getGeneratedKeys();
            while (rs.next()){
                datos= new Object[9];
                String registro;
                datos[0]=rs.getString("nombre");
                datos[1]=rs.getString("apellido1");
                datos[2]=rs.getString("apellido2");
                datos[3]=rs.getString("sexo");
                datos[4]=rs.getString("estado");
                datos[5]=rs.getString("año");
                datos[6]=rs.getString("dia");
                datos[7]=rs.getString("mes");
                datos[8]=rs.getString("curp");
                registro=" | "+datos[0]+" | "+datos[1]+" | "+datos[2]+" | "+datos[3]+"| "+datos[4]+" | "+datos[5]+" | "+datos[6]+" | "+datos[7]+" | "+datos[8]+" \n";
                personList.add(registro);
            }

        }catch (SQLException e){
            Logger.getLogger(daoCurp.class.getName())
                    .log(Level.SEVERE, "Error en Historial -> ", e);
        }finally {
            closeConnections();
        }
        return personList;
    }


    public boolean saveDatos(String nombre, String apellido1, String apellido2, String sexo, String estado, String año, String dia, String mes, String curp){
        try {
            conn = new MySQLConnection().getConnection();
            String query = INSERT_DATOS;
            //conn.setAutoCommit(false);
            pstm = conn.prepareStatement(query);
            pstm.setString(1, nombre);
            pstm.setString(2, apellido1);
            pstm.setString(3, apellido2);
            pstm.setString(4, sexo);
            pstm.setString(5, estado);
            pstm.setString(6, año);
            pstm.setString(7, dia);
            pstm.setString(8, mes);
            pstm.setString(9, curp);
            return pstm.executeUpdate()==1;
        }catch (SQLException e){
            Logger.getLogger(daoCurp.class.getName())
                    .log(Level.SEVERE, "Error al guardar la operacion -> ", e);
            try{
                conn.rollback();
            }catch (SQLException ex){
                System.out.println(ex);
            }
            return false;
        } /*finally {
            closeConnections();
        }*/
    }
    public void closeConnections(){
        try{
            if (conn!= null){
                conn.close();
            }
            if (pstm!= null){
                pstm.close();
            }
            if (rs!= null){
                rs.close();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}