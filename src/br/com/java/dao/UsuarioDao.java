package br.com.java.dao;

import java.sql.*;

import br.com.java.connection.DbConnect;
import br.com.java.model.Usuario;

public class UsuarioDao {
	
	
    public boolean registrarUsuario(Usuario usuario)  {

  
    	
        String SQL = "INSERT INTO usuarios VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm;
        

        

        try {
        	pstm = DbConnect.getConexao().prepareStatement(SQL);
        	
        
        	pstm.setInt(1,usuario.getUsuarioid());
            pstm.setString(2, usuario.getUnome());
            pstm.setString(3, usuario.getPwd());
            pstm.setString(4, usuario.getEmail());
            pstm.setString(5, usuario.getEndereco());
            pstm.setString(6, usuario.getTelefone());
           
            
            pstm.executeUpdate();
            
            usuario.setLogado(true);
            
            return true;
            
            



            
        } catch (Exception ex) {
            //TODO: handle exception
        	ex.printStackTrace();
        	
        	return false;
        }  
    }
    public static int salvarUsuario(Usuario usuario) {
    	
    	int status = 0;
    	
    	String SQL = "INSERT INTO usuarios VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm;
        
        try {
        	pstm = DbConnect.getConexao().prepareStatement(SQL);
        	
        
        	pstm.setInt(1,usuario.getUsuarioid());
            pstm.setString(2, usuario.getUnome());
            pstm.setString(3, usuario.getPwd());
            pstm.setString(4, usuario.getEmail());
            pstm.setString(5, usuario.getEndereco());
            pstm.setString(6, usuario.getTelefone());
           
            
            pstm.executeUpdate();
            
            usuario.setLogado(true);
          
            
        } catch (Exception ex) {
            //TODO: handle exception
        	ex.printStackTrace();
        	
        	
        }
        return status;
    }
    public  void limpar(Connection con, PreparedStatement ps)
    { 
      try
      { if ( ps != null )  ps.close();
        if ( con != null) con.close();
      }
       catch(Exception ex)
       { System.out.println(ex.getMessage()); }
    }
}
