package banco;

public class PessoaFisica extends Cliente {

    private int cpf;

    public PessoaFisica(String nome, Integer senha, int cpf) {
        super(nome, senha);
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
