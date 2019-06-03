package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Usuario> read() {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> lusuarios = new ArrayList<>();
        
        try {
           stmt = con.prepareStatement("SELECT * FROM tbusuarios");
           rs = stmt.executeQuery();
           
            while (rs.next()) {                
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("userid"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                
                lusuarios.add(usuario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return null;
        
    }
}
