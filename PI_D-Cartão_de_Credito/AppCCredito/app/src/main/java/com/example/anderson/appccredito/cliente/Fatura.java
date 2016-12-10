package com.example.anderson.appccredito.cliente;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by anderson on 09/11/16.
 */
public class Fatura implements Serializable{

    private Long idFatura;
    private String numero_cartao;
    private String local;
    private Double valor;
    private String data_acao;
    private String horario;

    public Long getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Long idFatura) {
        this.idFatura = idFatura;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData_acao() {
        return data_acao;
    }

    public void setData_acao(String data_acao) {
        this.data_acao = data_acao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
        if (!Objects.equals(this.numero_cartao,fatura.numero_cartao))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idFatura != null ? idFatura.hashCode() : 0;
    }
}
