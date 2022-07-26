package br.com.java.model;

import java.sql.*;
import java.util.*;

import javax.ejb.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;
import javax.naming.spi.NamingManager;
import javax.sql.DataSource;


import br.com.java.connection.DbConnect;

public class Carrinho {

	ArrayList itens = new ArrayList<>();

	public Item encontrar(String isbn) {
		Iterator iterator = itens.iterator();
		Item item;

		while(iterator.hasNext()) {
			item = (Item) iterator.next();

			if (item.getIsbn().equals(isbn)) {
				return item;
			}
		}
		return null;
	}
	
	// adiciona um item se ainda não existir
	// caso contrário adiciona 1 ao qtd
	public void adicionarItem(String isbn) {
		
		//verifica se isbn já está presente
		Item item = encontrar(isbn);

		if (item != null) 
			item.addQtd(1);
		else {

			// obtém detalhes das tabelas Books
			Connection con = null;
			//Usuario usuario = new Usuario();

			try {
				con = DbConnect.getConexao();
				PreparedStatement ps = con.prepareStatement("SELECT titulo, preco FROM livros WHERE isbn = ?");
				ps.setString(1, isbn);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					item = new Item(isbn, rs.getString(1), rs.getInt(2));
					
					itens.add(item);
				}
				rs.close();
				ps.close();

			} catch (Exception e) {
				//TODO: handle exception
				System.out.println(e.getMessage());
			} finally {
				try {
					con.close();
				} catch (Exception e) {
					//TODO: handle exception
				}
			}
		}
	}
    public ArrayList getItens() {
		return itens;
	}
	public void removerItem(String isbn) {

	}
	public void limparTudo() {}

	public void atualizarQtd(String isbn, int qtd) {

	}

	public String finalizarPedido(int usuarioid) {

		try {
			Context context = getInitialContext();

			PedidoPrincipal principal = (PedidoPrincipal) context.lookup("br.com.java.model.Pedido");
			Pedido pedido = principal.criar();

			String id = pedido.addPedido(usuarioid, itens);

			return id;

		} catch (Exception e) {
			//TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
	public boolean cancelarPedido() {

		return false;
	}

	public Context getInitialContext() 
  {
  
  String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";

  try
  {
   Hashtable env = new Hashtable();
   env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
   env.put(Context.PROVIDER_URL,"t3://localhost:7001");
   return new InitialContext(env);
  }
  catch(Exception ex)
  { 
    System.out.println(ex.getMessage()); 
    return null;
  }

 }
	// 	public Context getInitialContext() throws NamingException, SQLException {
	// 		// private DataSource dataSource;

			

	// 		Context initContext = new InitialContext();
	// 		Context envContext = (Context) initContext.lookup("java:comp/env");

	// 		Connection conn = DbConnect.getConexao();
	// 		DataSource ds = (DataSource) envContext.lookup("jdbc/Loja_Online_crud_java_web_jsp_mysql");
	// 		conn = ds.getConnection();
		
			

			
	// 		//setupInitialContext();
	// 		// String JNDI_FACTORY="java:comp/env";

	// 		// try {
	// 		// 	Hashtable env = new Hashtable();
	// 		// 	// Hashtable<String, String> env = new Hashtable<String, String>(); 
	// 		// 	env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
	// 		// 	env.put(Context.PROVIDER_URL, "t3://localhost:7001");
	// 		// 	// env.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory"); 
	// 		//     // env.put("java.naming.provider.url", "jnp://localhost:1099"); 
	// 		//     // env.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");

	// 		// 	return new InitialContext(env);
	// 		// } catch (Exception e) {
	// 		// 	//TODO: handle exception
	// 		// 	System.out.println(e.getMessage());

	// 			return null;
	// 		// }
	// 	}
	// 	private static void setupInitialContext() {
	// 		try {
	// 			NamingManager.setInitialContextFactoryBuilder(new InitialContextFactoryBuilder() {
		
	// 				@Override
	// 				public InitialContextFactory createInitialContextFactory(Hashtable<?, ?> environment) throws NamingException {
	// 					return new InitialContextFactory() {
		
	// 						@Override
	// 						public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
	// 							return new InitialContext(){
		
	// 								private Hashtable<String, DataSource> dataSources = new Hashtable<>();
		
	// 								@Override
	// 								public Object lookup(String name) throws NamingException {
		
	// 									if (dataSources.isEmpty()) { //init datasources

	// 										DbConnect ds = new DbConnect();
	// 										// DbConnect ds = new DbConnect();
	// 										// ds.setURL("jdbc:mysql://localhost:3306/mydb");
	// 										// ds.setUser("mydbuser");
	// 										// ds.setPassword("mydbpass");
	// 										dataSources.put("jdbc/mydbname", (DataSource) ds);
		
	// 										//add more datasources to the list as necessary
	// 									}
		
	// 									if (dataSources.containsKey(name)) {
	// 										return dataSources.get(name);
	// 									}
		
	// 									throw new NamingException("Unable to find datasource: "+name);
	// 								}
	// 							};
	// 						}
		
	// 					};
	// 				}
		
	// 			});
	// 		}
	// 		catch (NamingException ne) {
	// 			ne.printStackTrace();
	// 	}
	// }
}
