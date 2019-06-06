package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.connection.ConnectionFactory;
import model.vo.Esporte;



public class EsporteDAO {
   
    public boolean insert( Esporte esp ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            String slq = "INSERT INTO esporte ( nome, qtd_pessoas ) VALUES( ?, ? )";
            stmt = conn.prepareCall(slq);
            
                stmt.setString( 1, esp.getNome());
                stmt.setInt( 2, esp.getQuantidade_pessoas());

            return !stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException( "ERRO AO SALVAR ESPORTE: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        }    
    }
    
    public boolean delete( Esporte esp ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            String sql = "DELETE FROM esporte WHERE esporte_cod = ?";
            stmt = conn.prepareCall(sql);
                stmt.setInt( 1 , esp.getId());
                
            return !stmt.execute();
            
        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO DELETAR ESPORTE: ", ex ); 
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        } 
    }
    
    public boolean  upDate( Esporte esp ){
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            String sql = "UPDATE esporte SET nome = ?, qtd_pessoas = ?";
            stmt = conn.prepareCall(sql);
            
                stmt.setString( 1, esp.getNome());
                stmt.setInt( 2, esp.getQuantidade_pessoas());

            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            throw new RuntimeException( "ERRO AO ATUALIZAR ESPORTE: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        } 
    }
    
    public List<Esporte> listALL() {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Esporte> lista = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM esporte";
            
            stmt = conn.prepareCall(sql);
            rs = stmt.executeQuery();
            
            while( rs.next() ) {
                
                Esporte esp = new Esporte();
                
                esp.setId( rs.getInt( "esporte_cod" ));
                esp.setNome( rs.getString( "nome" ));
                esp.setQuantidade_pessoas( rs.getInt( "qtd_pessoas" ));
                
                lista.add(esp);
            }
            
        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO LISTAR TODOS ESPORTE: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt, rs );
        }
        
        return lista;
    } 
    
    public Esporte listOne( String nome ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Esporte esp = new Esporte();
        
        try {
            
            String sql = "SELECT * FROM esporte WHERE esporte_cod = '"+nome+"'";
            
            stmt = conn.prepareCall(sql);
            rs = stmt.executeQuery();
            
                esp.setId( rs.getInt( "esporte_cod" ));
                esp.setNome( rs.getString( "nome" ));
                esp.setQuantidade_pessoas( rs.getInt( "qtd_pessoas" ));

        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO LISTAR O ESPORTE: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt, rs );
        }
        
        return esp;

    } 
    
}
