package br.com.java.connection;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexao {
	
	// Informamos qual o Driver que est� sendo utilizado

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String URL = "jdbc:mysql://localhost:3306/pet?useTimezone=true&serverTimezone=UTC";

	private static final String USER = "root";

	private static final String PASSWORD = "senha";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

	try{

	 // O m�todo forName carrega e inicia o driver passado por par�metro

	Class.forName(DRIVER);

	 // Estabelecendo a conex�o

	return DriverManager.getConnection(URL, USER, PASSWORD);

	}catch(ClassNotFoundException | SQLException ex){ // Tratamento de Exce��es

	System.out.println(ex);

	return null;

	}

	}
}
