package com.example.anderson.appccredito.interfaces;

import com.example.anderson.appccredito.cliente.Fatura;

import java.util.List;

/**
 * Created by anderson on 21/11/16.
 */
public interface RespostaWeb {
    public void callBack (List<Fatura> response);
}
