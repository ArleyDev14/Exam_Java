package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost/banco_union";
    private static final String USER = "campus2023";
    private static final String PASSWORD = "campus2023";
    
public static Connection conectionDB() throws SQLException{
    
    return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}
