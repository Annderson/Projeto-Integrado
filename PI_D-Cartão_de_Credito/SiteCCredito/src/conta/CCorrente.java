package conta;

/**
 * Created by anderson on 28/10/16.
 */
public class CCorrente {

    public enum Bandeira{VISA,MASTERCARD,ELO,AMEX};

    private Long id_conta;
    private String nome;
    private String numero_conta;
    private String codigo_conta;
    private Bandeira bandeira;
    private Integer id_cliente;

    public Long getId_conta() {
        return id_conta;
    }

    public void setId_conta(Long id_conta) {
        this.id_conta = id_conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    public String getCodigo_conta() {
        return codigo_conta;
    }

    public void setCodigo_conta(String codigo_conta) {
        this.codigo_conta = codigo_conta;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (getClass() != o.getClass()))
            return false;

        CCorrente cCorrente = (CCorrente) o;

        if (!id_conta.equals(cCorrente.getId_conta()))
            return false;
        if (!numero_conta.equals(cCorrente.getNumero_conta()))
            return false;


        return true;

    }

    @Override
    public int hashCode() {
        return id_conta != null ? id_conta.hashCode() : 0;
    }
}
