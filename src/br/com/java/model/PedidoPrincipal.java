package br.com.java.model;

import java.rmi.RemoteException;

import javax.ejb.CreateException;

public interface PedidoPrincipal {
    
    Pedido criar() throws CreateException, RemoteException;
}
