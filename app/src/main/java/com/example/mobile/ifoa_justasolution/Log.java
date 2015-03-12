package com.example.mobile.ifoa_justasolution;

import com.example.mobile.ifoa_justasolution.EnumTipo;

/**
 * Created by mobile on 10/03/2015.
 */
public class Log {
    private String nome;
    private String email;
    private String pass;
    private Integer index;
    private EnumTipo tipo;

    public Log(String nome, String email, String pass, Integer index, EnumTipo tipo) {
        this.nome = nome;
        this.email = email;
        this.pass = pass;
        this.index = index;
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public EnumTipo getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipo tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
