package Cheques;

import DataBase.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RestarMonto {

    public static void restar_monto(float monto, String documento){
        String insercion = """
                           UPDATE cuentas cn
                           JOIN cheques ch ON ch.id_cuenta = cn.id
                           SET cn.saldo = ?
                           WHERE ch.id = ?
                           """;
        try(Connection conect = ConexionDB.conectionDB()){
            PreparedStatement orden = conect.prepareStatement(insercion);
            
            orden.setFloat(1,monto);
            orden.setString(2,documento);
            
            int seAgregoFila = orden.executeUpdate();
            
            if(seAgregoFila > 0){
                System.out.println("Se realizó el descuento de: " + monto + " a tu cuenta");
            }else{
                System.out.println("Lo sentimos! No pudimos hacer el descuento de saldo.");
            }
            
        } catch (SQLException ex) {
            System.out.println("EROR: " + ex);
        }
        
    }
    
}
