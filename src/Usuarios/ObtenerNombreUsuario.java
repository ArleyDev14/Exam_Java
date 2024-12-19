package Usuarios;

import DataBase.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObtenerNombreUsuario {
    
    public static String obtener_nombre_usuario(String documento){
        String nombre = "";
        String consulta = """
                              SELECT CONCAT(cl.nombre," ",cl.apellido) AS nombre
                              FROM clientes cl
                              WHERE cl.identificacion = ?;
                              """;
        try(Connection conect = ConexionDB.conectionDB()){
            PreparedStatement orden = conect.prepareStatement(consulta);
            
            orden.setString(1,documento);
            
            ResultSet rs = orden.executeQuery();
            
            if (rs.next()){
                nombre = rs.getString("nombre");
            }else{
                System.out.println("No se pudo encontrar el nombre del Usuario");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
        return nombre;
    }
    
}
