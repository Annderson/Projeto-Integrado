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
    private Long numero_conta;
    private Double valor;
    private String local;
    private Date data_compra;

    public Long getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Long idFatura) {
        this.idFatura = idFatura;
    }

    public Long getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(Long numero_conta) {
        this.numero_conta = numero_conta;
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

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
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
        if (!Objects.equals(this.numero_conta, other.numero_conta)) {
            return false;
        }
        return true;
    }
    
    
    
}
