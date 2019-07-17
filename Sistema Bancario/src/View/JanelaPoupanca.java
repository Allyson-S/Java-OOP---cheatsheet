package View;

import banco.Banco;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JanelaPoupanca extends JFrame implements ActionListener {


    private JPanel pnDados;
    private JPanel pnBotoes;

    private JTextField tfNumAgencia;
    private JTextField tfNumero;
    private JTextField tfValor;

    private JButton btDepositar;
    private JButton btSacar;
    private JButton btSaldo;
    private String login;

    JanelaPoupanca() {
        pnDados = new JPanel();
        pnBotoes = new JPanel();

        this.setLayout(new BorderLayout());

        this.add(pnDados, BorderLayout.NORTH);
        this.add(pnBotoes, BorderLayout.SOUTH);

        pnDados.setLayout(new GridLayout(6, 1));
        pnBotoes.setLayout(new GridLayout(1, 3));

        JLabel lbNumAgencia = new JLabel("Numero da Agencia:");
        JLabel lbNumero = new JLabel("Numero da Conta:");
        JLabel lbValor = new JLabel("Valor:");

        tfNumAgencia = new JTextField(10);
        tfNumero = new JTextField(15);
        tfValor = new JTextField(10);

        pnDados.add(lbNumAgencia);
        pnDados.add(tfNumAgencia);
        pnDados.add(lbNumero);
        pnDados.add(tfNumero);
        pnDados.add(lbValor);
        pnDados.add(tfValor);

        btDepositar = new JButton("Depositar");
        btSacar = new JButton("Sacar");
        btSaldo = new JButton("Saldo");

        pnBotoes.add(btDepositar);
        pnBotoes.add(btSacar);
        pnBotoes.add(btSaldo);


        btDepositar.addActionListener(this);
        btSacar.addActionListener(this);
        btSaldo.addActionListener(this);


        this.setTitle("Conta Corrente");
        this.setSize(350, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btDepositar) {
            login = JOptionPane.showInputDialog(null, "Senha Conta", "Autenticação", 3);
            Banco.depositar(tfNumAgencia.getText(), tfNumero.getText(), tfValor.getText(), login);
        }

        if (e.getSource() == btSacar) {
            login = JOptionPane.showInputDialog(null, "Senha Conta", "Autenticação", 3);
            Banco.sacar(tfNumAgencia.getText(), tfNumero.getText(), tfValor.getText(), login);
        }

        if (e.getSource() == btSaldo) {
            login = JOptionPane.showInputDialog(null, "Senha Conta", "Autenticação", 3);
            Banco.saldo(tfNumAgencia.getText(), tfNumero.getText(), login);
        }
    }

}
