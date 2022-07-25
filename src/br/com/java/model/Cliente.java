package br.com.java.model;

import javax.naming.Context;

public class Cliente {
    
    private String clinome;
    private String password;
    private String email;
    private String telelefoneno;

    private Context ctx;

    public String getClinome() {
        return clinome;
    }

    public void setClinome(String clinome) {
        this.clinome = clinome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelelefoneno() {
        return telelefoneno;
    }

    public void setTelelefoneno(String telelefoneno) {
        this.telelefoneno = telelefoneno;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    
}
