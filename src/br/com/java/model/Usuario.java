package br.com.java.model;

public class Usuario {

    private int usuarioid;
    private String unome;
    private String pwd;
    private String email;
    private String endereco;
    private String telefone;

    private boolean logado = false;

    public int getUsuarioid() {
        return usuarioid;
    }

    public String getUnome() {
        return unome;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isLogado() {
        return logado;
    }

    
}
