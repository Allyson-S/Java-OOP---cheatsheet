package banco;

import View.JanelaPrin;
import banco.Agencia;
import banco.Conta;

import javax.swing.*;
import java.util.ArrayList;

public class Banco {

    private static ArrayList<Agencia> agenciaCadastrado = new ArrayList();
    private static ArrayList<Agencia> contaCadastro = new ArrayList();

    public static void main(String[] args) {

        new JanelaPrin();

    }

    public static void cadastroAg(String nAgencia, String senhaG) {

        int flag = 0, aux;
        if(agenciaCadastrado.size() > 0 ) {
            for (int i = 0; i < agenciaCadastrado.size(); i++) {
                if (agenciaCadastrado.get(i).getNumAgencia() == Integer.parseInt(nAgencia)) {

                    String msg = "Agencia já existente, não foi possivel cadastrar";
                    JOptionPane.showMessageDialog(null, msg, "Erro Agencia", JOptionPane.PLAIN_MESSAGE);
                    flag = 1;
                }
            }
        }

        if(flag == 0 ) {

            Agencia agencias = new Agencia(Integer.parseInt(nAgencia), senhaG, null);
            agenciaCadastrado.add(agencias);
            String msg = "Cadastrado com Sucesso!";

            JOptionPane.showMessageDialog(null, msg, "Efetuado com Sucesso", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static int loginAgencia(String nAgencia, String senhaG){

        for (int i = 0; i< agenciaCadastrado.size(); i++) {
            if (agenciaCadastrado.get(i).getNumAgencia() == Integer.parseInt(nAgencia) && agenciaCadastrado.get(i).getSenhaGerente().equals(senhaG)) {
                return 1;
            }
        }
        return 0;
    }

    public static void cadastroConta(String nAgencia, String senhaG, Conta conta) {

        Agencia contas = new Agencia(Integer.parseInt(nAgencia), senhaG, conta);
        contaCadastro.add(contas);

        String msg = "Cadastrado com Sucesso!";

        JOptionPane.showMessageDialog(null, msg, "Efetuado com Sucesso", JOptionPane.PLAIN_MESSAGE);

    }

    public static void encerrarConta(String nAgencia, String senhaG, String senhaCliente, String numeroConta) {

        for (int i = 0; i< contaCadastro.size(); i++) {
            if (contaCadastro.get(i).getNumAgencia() == Integer.parseInt(nAgencia) && contaCadastro.get(i).getSenhaGerente().equals(senhaG)) {
                if (contaCadastro.get(i).getConta().getCliente().getSenha() == Integer.parseInt(senhaCliente) && contaCadastro.get(i).getConta().getNumero() == Integer.parseInt(numeroConta)) {

                    contaCadastro.get(i).getConta().encerrarConta();

                    JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar a conta de número: "+contaCadastro.get(i).getConta().getNumero()+". Na agência de número:\n  "+
                            contaCadastro.get(i).getNumAgencia()+", cujo cliente é: " +contaCadastro.get(i).getConta().getCliente().getNome()+" ?","Encerramento de Conta",JOptionPane.YES_OPTION);

                    JOptionPane.showMessageDialog(null, "Ok. A conta : "+contaCadastro.get(i).getConta().getNumero()+". foi encerrada com sucesso.o saldo após o fechamento é de :" +
                            +contaCadastro.get(i).getConta().getSaldo()+", cujo cliente é: " +contaCadastro.get(i).getConta().getCliente().getNome()+" ","Encerramento de Conta",JOptionPane.YES_OPTION);

                }

            }
        }

    }

    public static void depositar(String nAgencia, String numConta, String valor, String senha) {
        for (int i = 0; i < contaCadastro.size(); i++) {
            if (contaCadastro.get(i).getNumAgencia() == Integer.parseInt(nAgencia) && contaCadastro.get(i).getConta().getNumero() == Integer.parseInt(numConta) && contaCadastro.get(i).getConta().getCliente().getSenha() == Integer.parseInt(senha)) {
                contaCadastro.get(i).getConta().depositar((float) Double.parseDouble(valor));

                JOptionPane.showMessageDialog(null, "Valor depositado: R$"+(Double.parseDouble(valor))+". \n na Conta de "+contaCadastro.get(i).getConta().getCliente().getNome()+". ","Deposito",JOptionPane.PLAIN_MESSAGE);
            }

        }

    }

    public static void sacar(String nAgencia, String numConta, String valor, String senha) {
        for (int i = 0; i < contaCadastro.size(); i++) {
            if (contaCadastro.get(i).getNumAgencia() == Integer.parseInt(nAgencia) && contaCadastro.get(i).getConta().getNumero() == Integer.parseInt(numConta) && contaCadastro.get(i).getConta().getCliente().getSenha() == Integer.parseInt(senha)) {

                contaCadastro.get(i).getConta().sacar((float) Double.parseDouble(valor));

                JOptionPane.showMessageDialog(null, "Valor sacado: R$" +(Double.parseDouble(valor))+". \n na Conta de "+contaCadastro.get(i).getConta().getCliente().getNome()+". ","Saque",JOptionPane.PLAIN_MESSAGE);
            }

        }

    }

    public static void saldo(String nAgencia, String numConta, String senha) {
        for (int i = 0; i < contaCadastro.size(); i++) {
            if (contaCadastro.get(i).getNumAgencia() == Integer.parseInt(nAgencia) && contaCadastro.get(i).getConta().getNumero() == Integer.parseInt(numConta) && contaCadastro.get(i).getConta().getCliente().getSenha() == Integer.parseInt(senha)) {
                JOptionPane.showMessageDialog(null, "Saldo é de : R$"+contaCadastro.get(i).getConta().getSaldo()+". \n na Conta de "+contaCadastro.get(i).getConta().getCliente().getNome()+". ","Saldo",JOptionPane.PLAIN_MESSAGE);
            }

        }

    }
}

