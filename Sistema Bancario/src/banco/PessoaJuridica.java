package banco;

public class PessoaJuridica extends Cliente {

    private int cnpj;

    public PessoaJuridica(String nome, Integer senha, int cnpj) {
        super(nome, senha);
        this.cnpj = cnpj;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
}