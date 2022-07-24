package br.com.java.dao;

import java.sql.*;

import br.com.java.connection.ConexaoDAO;
import br.com.java.connection.DbConnect;
import br.com.java.model.Usuario;

public class UsuarioDao {
	
	
    public boolean registrarUsuario(Usuario usuario)  {

    	Connection con;
    	PreparedStatement pstm;
    	ResultSet rs;
    	
    	
        String SQL = "INSERT INTO usuarios VALUES(?,?,?,?,?,?)";
        

        

        try {
        	pstm = DbConnect.getConexao().prepareStatement(SQL);
            pstm.setInt(1, usuario.getUsuarioid());
            pstm.setString(2, usuario.getUnome());
            pstm.setString(3, usuario.getPwd());
            pstm.setString(4, usuario.getEmail());
            pstm.setString(5, usuario.getEndereco());
            pstm.setString(6, usuario.getTelefone());
            pstm.executeUpdate(SQL);
            
            return true;
            
            



            
        } catch (Exception ex) {
            //TODO: handle exception
        	ex.printStackTrace();
        	
        	return false;
        }  
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
