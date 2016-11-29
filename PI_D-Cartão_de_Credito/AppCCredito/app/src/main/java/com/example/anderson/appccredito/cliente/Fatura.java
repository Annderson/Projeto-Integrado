package com.example.anderson.appccredito.cliente;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by anderson on 09/11/16.
 */
public class Fatura implements Serializable{

    private Long idFatura;
    private Date data_compra;
    private Date horario;
    private Double valor;
    private String conta;
    private String local;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Long getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Long idFatura) {
        this.idFatura = idFatura;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Fatura fatura = (Fatura) o;

        if (!Objects.equals(idFatura,fatura.idFatura))
            return false;
        if (!Objects.equals(conta,fatura.conta))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idFatura != null ? idFatura.hashCode() : 0;
    }
}
