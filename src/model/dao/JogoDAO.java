package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.connection.ConnectionFactory;
import model.vo.Jogo;



public class JogoDAO {
    

    public boolean insert( Jogo jogo ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            String slq = "INSERT INTO jogos ( data_camp, hora ) VALUES( ?, ? )";
            stmt = conn.prepareCall(slq);
            
                stmt.setDate( 1, (Date) jogo.getData());
                stmt.setTimestamp( 2, jogo.getHora());

            return !stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException( "ERRO AO SALVAR JOGO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        }    
    }
    
    public boolean delete( Jogo jogo ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            String sql = "DELETE FROM jogos WHERE id = ?";
            stmt = conn.prepareCall(sql);
                stmt.setInt( 1 , jogo.getId());
                
            return !stmt.execute();
            
        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO DELETAR JOGO: ", ex ); 
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        } 
    }
    
    public boolean  upDate( Jogo jogo ){
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            String sql = "UPDATE jogos SET data_camp = ?, hora = ?";
            stmt = conn.prepareCall(sql);
            
                stmt.setDate( 1, (Date) jogo.getData());
                stmt.setTimestamp( 2, jogo.getHora());

            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            throw new RuntimeException( "ERRO AO ATUALIZAR JOGO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        } 
    }
    
    public List<Jogo> listALL() {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Jogo> lista = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM jogos";
            
            stmt = conn.prepareCall(sql);
            rs = stmt.executeQuery();
            
            while( rs.next() ) {
                
                Jogo j = new Jogo();
                
                j.setId( rs.getInt("cod_camp_id"));
                j.setData( rs.getDate("data_camp"));
                j.setHora(rs.getTimestamp("hora"));
                
                lista.add(j);
            }
            
        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO LISTAR TODOS JOGO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt, rs );
        }
        
        return lista;
    } 
    
    public Jogo listOne( String id ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Jogo j = new Jogo();
        
        try {
            
            String sql = "SELECT * FROM jogos WHERE cod_camp_id = ?";
            
            stmt = conn.prepareCall(sql);
                stmt.setString( 1, id );
                
            rs = stmt.executeQuery();
            
                j.setId( rs.getInt("cod_camp_id"));
                j.setData( rs.getDate("data_camp"));
                j.setHora(rs.getTimestamp("hora"));

        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO LISTAR O JOGO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt, rs );
        }
        
        return j;

    } 
      
}
