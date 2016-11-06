/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes_auxiliares;

import java.util.Objects;

/**
 *Classe espelho, da entidade CCorrente do banco de dados.
 * Para ser auxiliar nos comandos de setar e obter dados do banco.
 * @author anderson
 */
public class CCorrente {
    
    private Long idConta;
    private Long idCliente;
    private String numero_conta;
    private String codigo;
    private String numero_cartao;
    private Double total;

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }    

    public String getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idConta);
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
        final CCorrente other = (CCorrente) obj;
        
        if (!Objects.equals(this.idConta, other.idConta)) {
            return false;
        }
        if (!Objects.equals(this.numero_conta, other.numero_conta)) {
            return false;
        }
        return true;
    }  
    
}
