package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.connection.ConnectionFactory;
import model.vo.Usuario;


/**
 *
 * @author DHEYSON
 */
public class UsuarioDAO {
    
    public void create(Usuario u) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbusuarios (nome, login, senha) VALUES(?, ?, ?)");
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
           
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
