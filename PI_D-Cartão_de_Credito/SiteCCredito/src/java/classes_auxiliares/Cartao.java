/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes_auxiliares;

/**
 *
 * @author anderson
 */
public class Cartao {
    
    private Long idCartao;
    private String numero_cartao;
    private String numero_conta;
    private Double anuidade;
    private String estado;

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public Long getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Long idCartao) {
        this.idCartao = idCartao;
    }

    public String getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
     public Double getAnuidade() {
        return anuidade;
    }

    public void setAnuidade(Double anuidade) {
        this.anuidade = anuidade;
    }
    
}
