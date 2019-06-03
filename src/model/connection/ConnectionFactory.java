package model.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * 
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver"; 
    private static final String URL    = "jdbc:mysql://localhost:3306/club_bd_ap2"+"?useTimezone=true&serverTimezone=UTC";//PROTOCOLO DE COMUNICAÇÃO
    private static final String USER   = "root"; // MEU USUARIO - ALTERAR AQUI
    private static final String PASS   = "password"; // MINHA SENHA - ALTERAR AQUI
    
    public static Connection getConnection() {
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro na Conexão");
        }
        return null;
}
    public static void closeConnection(Connection con) {
        if (con != null) { 
        try {
            con.commit();
            con.close();
        } catch (SQLException e) {
            System.err.println("Erro na Conexão");
            e.getErrorCode();
         
        }
    } 
    }
    public static void closeConnection(Connection con,PreparedStatement stat) {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Erro na Conexão");
                e.getErrorCode();
             }
        }
     
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con,PreparedStatement stat,ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                 System.err.println("Erro na Conexão:");
                 e.getErrorCode();
               
                 }
        }
        closeConnection(con, stat);
    }
}
