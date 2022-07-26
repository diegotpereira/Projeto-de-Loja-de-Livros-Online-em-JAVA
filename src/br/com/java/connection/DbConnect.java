package br.com.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	
	public static Connection getConexao() {
        Connection con = null;
        try {
            String serverName = "localhost";
            String mydatabase = "Loja_Online_crud_java_web_jsp_mysql";
            String username = "root";
            String password = "root";
            String driverName = "com.mysql.cj.jdbc.Driver";	
            Class.forName(driverName);
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado " + e.toString());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar o Banco de Dados " + e.toString());
        }
        return con;
    }

}
