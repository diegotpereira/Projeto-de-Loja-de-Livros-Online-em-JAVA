package br.com.java.model;

import java.io.Serializable;

public class Item implements Serializable{

    private String isbn;
    private String titulo;
    private int preco;
    private int qtd;

    

    public Item(String isbn, String titulo, int preco) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.preco = preco;
        this.qtd = 1;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public void addQtd(int qtd) {
        this.qtd += qtd;
    }
}
