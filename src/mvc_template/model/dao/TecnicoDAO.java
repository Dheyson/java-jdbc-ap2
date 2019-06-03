package mvc_template.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.connection.ConnectionFactory;
import model.vo.Tecnico;



public class TecnicoDAO {
    

    public boolean insert( Tecnico tec ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            String slq = "INSERT INTO tecnico ( nome, sobrenome, epecializacao ) VALUES( ?, ?, ? )";
            stmt = conn.prepareCall(slq);
            
                stmt.setString( 1, tec.getNome());
                stmt.setString( 2, tec.getSobrenome());
                stmt.setString( 3, tec.getEspecializacao());
 
            return !stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException( "ERRO AO SALVAR TÉCNICO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        }    
    }
    
    public boolean delete( Tecnico tec ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            String sql = "DELETE FROM tecnico WHERE registro = ?";
            stmt = conn.prepareCall(sql);
                stmt.setInt( 1 , tec.getId());
                
            return !stmt.execute();
            
        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO DELETAR TÉCNICO: ", ex ); 
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        } 
    }
    
    public boolean  upDate( Tecnico tec ){
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            String sql = "UPDATE tecnico SET nome = ?, sobrenome = ? , epecializacao = ?";
            stmt = conn.prepareCall(sql);
            
                stmt.setString( 1, tec.getNome());
                stmt.setString( 2, tec.getSobrenome());
                stmt.setString( 3, tec.getEspecializacao());

            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            throw new RuntimeException( "ERRO AO ATUALIZAR TÉCNICO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        } 
    }
    
    public List<Tecnico> listALL() {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Tecnico> lista = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM tecnico";
            
            stmt = conn.prepareCall(sql);
            rs = stmt.executeQuery();
            
            while( rs.next() ) {
                
                Tecnico tec = new Tecnico();
                
                tec.setID( rs.getInt("registro"));
                tec.setNome( rs.getString("nome"));
                tec.setSobrenome( rs.getString("sobrenome"));
                tec.setEspecializacao( rs.getString("epecializacao"));
                
                lista.add(tec);
            }
            
        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO LISTAR TODOS TÉCNICO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt, rs );
        }
        
        return lista;
    } 
    
    public Tecnico listOne( String id ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Tecnico tec = new Tecnico();
        
        try {
            
            String sql = "SELECT * FROM tecnico WHERE id = ?";
            
            stmt = conn.prepareCall(sql);
                stmt.setString( 1, id );
                
            rs = stmt.executeQuery();
            
                tec.setID( rs.getInt("registro"));
                tec.setNome( rs.getString("nome"));
                tec.setSobrenome( rs.getString("sobrenome"));
                tec.setEspecializacao( rs.getString("epecializacao"));
            
        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO LISTAR O TÉCNICO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt, rs );
        }
        
        return tec;

    } 
    
}
