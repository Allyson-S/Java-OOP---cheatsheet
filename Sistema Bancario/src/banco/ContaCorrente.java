package banco;

public class ContaCorrente extends Conta  {

    public ContaCorrente(Cliente cliente, int numero, Double saldo) {
        super(cliente, numero, saldo);
    }

    @Override
    public void encerrarConta() {

        double resultado = 0 ;

        resultado = getSaldo() - (getSaldo() * 1.20 / 100);

        this.setSaldo(resultado - (getNumero() * 0.8 / 100));

    }

}
