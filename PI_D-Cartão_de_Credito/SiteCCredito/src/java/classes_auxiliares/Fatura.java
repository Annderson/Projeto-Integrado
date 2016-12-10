/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes_auxiliares;

import java.util.Date;
import java.util.Objects;

/**
 *Classe espelho, da entidade Fatura do banco de dados.
 * Para ser auxiliar nos comandos de setar e obter dados do banco.
 * @author anderson
 */
public class Fatura {
    
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.idFatura);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fatura other = (Fatura) obj;
        if (!Objects.equals(this.idFatura, other.idFatura)) {
            return false;
        }
        if (!Objects.equals(this.numero_cartao, other.numero_cartao)) {
            return false;
        }
        return true;
    }  
    
}
