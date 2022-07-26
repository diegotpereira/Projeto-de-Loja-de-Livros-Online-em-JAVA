package br.com.java.model;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.ejb.*;

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
	public Context getInitialContext() {
		
		String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";

		try {
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
			env.put(Context.PROVIDER_URL, "t3://localhost:7001");

			return new InitialContext(env);
		} catch (Exception e) {
			//TODO: handle exception
			System.out.println(e.getMessage());

			return null;
		}
	}
}
