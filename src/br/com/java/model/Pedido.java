package br.com.java.model;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.ejb.EJBObject;

public interface Pedido extends EJBObject{
    
    public String addPedido(int usuarioid, ArrayList itens) throws RemoteException;
    public boolean cancelarPedido(int pedidoid) throws RemoteException;
}
