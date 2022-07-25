package br.com.java.model;

public class Usuario {

    private int usuarioid;
    private String unome;
    private String pwd;
    private String email;
    private String endereco;
    private String telefone;

    private boolean logado = false;

    

    public Usuario() {
    }

    

    public Usuario(String unome, String pwd, String email, String endereco, String telefone, boolean logado) {
        this.unome = unome;
        this.pwd = pwd;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.logado = logado;
    }



    public int getUsuarioid() {
        return usuarioid;
    }



    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }



    public String getUnome() {
        return unome;
    }



    public void setUnome(String unome) {
        this.unome = unome;
    }



    public String getPwd() {
        return pwd;
    }



    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getEndereco() {
        return endereco;
    }



    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }



    public String getTelefone() {
        return telefone;
    }



    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    public boolean isLogado() {
        return logado;
    }



    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    
    
}
