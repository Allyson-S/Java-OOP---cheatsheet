package banco;

public class Agencia {

    private Integer numAgencia;
    private String senhaGerente;
    private Conta conta;

    public Agencia(Integer numAgencia, String senhaGerente, Conta conta) {
        this.numAgencia = numAgencia;
        this.senhaGerente = senhaGerente;
        this.conta = conta;
    }

    public Integer getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(Integer numAgencia) {
        this.numAgencia = numAgencia;
    }

    public String getSenhaGerente() {
        return senhaGerente;
    }

    public void setSenhaGerente(String senhaGerente) {
        this.senhaGerente = senhaGerente;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}



