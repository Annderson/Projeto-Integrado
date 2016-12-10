package com.example.anderson.appccredito.cliente;

import java.io.Serializable;

/**
 * Created by anderson on 29/11/16.
 */
public class Cliente implements Serializable {

    private String cpf;
    private String senha;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
