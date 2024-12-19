package Usuarios;

import DataBase.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class ObtenerCheque {
    public static List<String[]> getCheques(String documento){
        List<String[]> data = new ArrayList<>();
        String consulta = """
                              SELECT CONCAT(cl.nombre," ",cl.apellido) AS cliente_emisor, ch.beneficiario AS beneficiario, ch.monto AS monto, ch.prioridad AS prioridad
                              FROM clientes cl
                              JOIN cuentas cn ON cn.id_cliente = cl.id
                              JOIN cheques ch ON ch.id_cuenta = cn.id
                              WHERE cl.identificacion = ?;
                              """;
        try(Connection conect = ConexionDB.conectionDB()){
            PreparedStatement orden = conect.prepareStatement(consulta);
            
            orden.setString(1,documento);
            
            ResultSet rs = orden.executeQuery();
            
            while(rs.next()){
                String[] row = new String[4];
                row[0] = rs.getString("cliente_emisor");
                row[1] = rs.getString("beneficiario");
                row[2] = rs.getString("monto");
                row[3] = rs.getString("prioridad");
                data.add(row);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
        return data;
    }
    
}
