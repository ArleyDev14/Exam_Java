package Cheques;

import DataBase.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearCheque {
    public static void crear_cheque(int id_cuenta,String nombre,float monto,String monto_letras,String prioridad, String Firma_digital){
        String insercion = "INSERT INTO cheques(id_cuenta, beneficiario, monto, monto_letras, prioridad, firma_digital,fecha_emision)VALUES(?,?,?,?,?,?,NOW())";
        
        try(Connection conect = ConexionDB.conectionDB()){
            PreparedStatement orden = conect.prepareStatement(insercion);
            
            orden.setFloat(1,id_cuenta);
            orden.setString(2,nombre);
            orden.setFloat(3,monto);
            orden.setString(4,monto_letras);
            orden.setString(5,prioridad);
            orden.setString(6,Firma_digital);
            
            int seAgregoFila = orden.executeUpdate();
            
            if(seAgregoFila > 0){
                System.out.println("Se realizó con éxito tu cheque!!!");
            }else{
                System.out.println("Lo sentimos! No pudimos crear tu cheque :c");
            }
            
        } catch (SQLException ex) {
            System.out.println("EROR: " + ex);
        }
    }
}
