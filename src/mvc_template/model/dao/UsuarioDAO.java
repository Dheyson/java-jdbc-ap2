package mvc_template.model.dao;

import mvc_template.model.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import mvc_template.model.vo.Usuario;

/**
 *
 * @author DHEYSON
 */
public class UsuarioDAO {
    
    public void create(Usuario u) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbusuarios (nome, login, senha, active) VALUES(?, ?, ?, ?)");
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setBoolean(4, u.isAtivo());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
