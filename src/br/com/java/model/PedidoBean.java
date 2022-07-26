package br.com.java.model;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import br.com.java.connection.DbConnect;

public class PedidoBean implements SessionBean{

    @Override
    public void ejbActivate() throws EJBException, RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ejbRemove() throws EJBException, RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setSessionContext(SessionContext context) throws EJBException, RemoteException {
        // TODO Auto-generated method stub
        
    }
    public void ejbCriar() throws CreateException {}
    	
    public String addPedido(int usuarioid, ArrayList itens) {
        Connection con = DbConnect.getConexao();
        String pedidoid;
        PreparedStatement ps = null;

        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("oracle");

            con = ds.getConnection();

            // obtém o id de pedido mais alto + 1 para este pedido
            ps = con.prepareStatement("SELECT pedidoid.nextval FROM dual");

            ResultSet rs = ps.executeQuery();
            rs.next();

            pedidoid = rs.getString(1);

            rs.close();

            // obter o valor total
            int valorTotal = 0;
            Item item;

            Iterator iterator = itens.iterator();

            while(iterator.hasNext()) {
                item = (Item) iterator.next();

                // calculando valor total
                valorTotal += item.getPreco() * item.getQtd();
            }
            ps = con.prepareStatement("INSERT INTO pedidos VALUES(?,?, sysdate, ? 'n')");
            ps.setString(1, pedidoid);
            ps.setInt(2, usuarioid);
            ps.setInt(3, valorTotal);

            ps.executeUpdate();
            ps.close();

            // inserir em itens de pedido
            ps = con.prepareStatement("INSERT INTO pedidoitem VALUES(?, ?, ?, ?)");

            iterator = itens.iterator();

            while(iterator.hasNext()) {
                item = (Item) iterator.next();
                ps.setString(1, pedidoid);
                ps.setString(2, item.getIsbn());
                ps.setInt(3, item.getPreco());
                ps.setInt(4, item.getQtd());

                ps.executeUpdate();
            }

            return pedidoid;

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                if(ps != null) ps.close();
                if(con != null) con.close();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        return null;
    }
}
