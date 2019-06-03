package mvc_template.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.connection.ConnectionFactory;
import model.vo.Associado;



public class AssociadoDAO {
    
    
    public boolean insert( Associado assoc ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            String slq = "INSERT INTO associado (cpf, nome, sobrenome, data_nascimento, sexo, email ) VALUES( ?, ?, ?, ?, ?, ? )";
            stmt = conn.prepareCall(slq);
            
                stmt.setString( 1, assoc.getCpf());
                stmt.setString( 2, assoc.getNome());
                stmt.setString( 3, assoc.getSobrenome());
                stmt.setDate( 4, ( java.sql.Date ) assoc.getData_nascimento());
                stmt.setString( 5, String.valueOf(assoc.getSexo()));
                stmt.setString( 6, assoc.getEmail()); 
            
            return !stmt.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException( "ERRO AO SALVAR ASSOCIADO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        }    
    }
    
    public boolean delete( Associado assoc ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            String sql = "DELETE FROM associado WHERE cpf = ?";
            stmt = conn.prepareCall(sql);
                stmt.setString( 1 , assoc.getCpf());
                
            return !stmt.execute();
            
        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO DELETAR ASSOCIADO: ", ex ); 
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        } 
    }
    
    public boolean  upDate( Associado assoc ){
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            String sql = "UPDATE associado SET cpf = ?, nome = ?, sobrenome = ?, data_nascimento = ?, sexo = ?, email = ? ";
            stmt = conn.prepareCall(sql);
            
                stmt.setString( 1, assoc.getCpf());
                stmt.setString( 2, assoc.getNome());
                stmt.setString( 3, assoc.getSobrenome());
                stmt.setDate( 4, ( java.sql.Date ) assoc.getData_nascimento());
                stmt.setString( 5, String.valueOf(assoc.getSexo()));
                stmt.setString( 6, assoc.getEmail()); 
        
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            throw new RuntimeException( "ERRO AO ATUALIZAR ASSOCIADO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt );
        } 
    }
    
    public List<Associado> listALL() {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Associado> lista = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM associado";
            
            stmt = conn.prepareCall(sql);
            rs = stmt.executeQuery();
            
            while( rs.next() ) {
                
                Associado a = new Associado();
                
                a.setCpf( rs.getNString( "cpf" ));
                a.setNome( rs.getNString( "nome" ));
                a.setSobrenome( rs.getNString( "sobrenome" ));
                a.setData_nascimento( rs.getDate( "data_nascimento" ));
                a.setSexo( rs.getNString( "cpf" ).charAt(0));
                a.setEmail( rs.getNString( "email" ));
                
                lista.add(a);
            }
            
        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO LISTAR TODOS ASSOCIADO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt, rs );
        }
        
        return lista;
    } 
    
    public Associado listOne( String cpf ) {
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Associado a = new Associado();
        
        try {
            
            String sql = "SELECT * FROM associado WHERE cpf = ?";
            
            stmt = conn.prepareCall(sql);
                stmt.setString( 1, cpf );
                
            rs = stmt.executeQuery();
            
                a.setCpf( rs.getNString( "cpf" ));
                a.setNome( rs.getNString( "nome" ));
                a.setSobrenome( rs.getNString( "sobrenome" ));
                a.setData_nascimento( rs.getDate( "data_nascimento" ));
                a.setSexo( rs.getNString( "cpf" ).charAt(0));
                a.setEmail( rs.getNString( "email" ));

        } catch ( SQLException ex ) {
            throw new RuntimeException( "ERRO AO LISTAR O ASSOCIADO: ", ex );
        } finally {
            ConnectionFactory.closeConnection( conn, stmt, rs );
        }
        
        return a;

    } 
      
}
