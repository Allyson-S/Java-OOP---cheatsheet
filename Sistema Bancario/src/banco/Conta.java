package banco;

public abstract class Conta {

    private Cliente cliente;
    private int numero;
    private double saldo = 0;


    public void depositar(float v) {


            this.setSaldo(this.getSaldo() + v);
            System.out.println("deposito efetuado");

    }

    public void sacar(float v) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("saque realizado na conta");
            } else {
                System.out.println("saldo insulficiente");
            }

    }

    public void saldoConta() {
        System.out.println("saque realizado na conta" + getSaldo());
    }

    public abstract void encerrarConta();

    public Conta(Cliente cliente, int numero, Double saldo) {
        this.cliente = cliente;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
