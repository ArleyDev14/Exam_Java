package Usuarios;

import DataBase.ConexionDB;
import java.sql.*;

public class VerificarCuenta {

    public static boolean verificar_cuenta(String documento, float saldo, int id_cuenta){
        String consulta;
        consulta = """
                   SELECT cn.id, cl.identificacion, cl.estado, cn.estado, cn.saldo
                   FROM cuentas cn 
                   JOIN clientes cl ON cl.id = cn.id_cliente
                   WHERE cl.estado = 'Activo' AND cn.estado = 'Activa' AND cn.saldo >= ? AND cl.identificacion = ? AND cn.id = ?;""";
        
        boolean vf = false;
        
        try(Connection conect = ConexionDB.conectionDB()){
            PreparedStatement orden = conect.prepareStatement(consulta);
            
            orden.setFloat(1,saldo);
            orden.setString(2,documento);
            orden.setInt(3,id_cuenta);
            
            ResultSet rs = orden.executeQuery();
            
            if(rs.next()){
                System.out.println("Cumple todos los requisitos para el cheque!");
                vf = true;
            }else{
                System.out.println("Lo sentimos! No cumples con los requisitos necesarios para realizar tu cheque.");
                vf = false;
            }
        } catch (SQLException ex) {
            System.out.println("EROR: " + ex);
        }
        return vf;
    }
}


