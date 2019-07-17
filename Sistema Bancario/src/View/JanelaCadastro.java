package View;

import banco.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class JanelaCadastro extends JFrame implements ActionListener  {

    private JPanel pnDados;
    private JPanel pnBotoes;

    private JTextField tfNome;
    private JTextField tfSenha;
    private JTextField tfCpf;
    private JTextField tfCnpj;
    private JTextField tfNumero;
    private JTextField tfSaldo;

    private JButton btCorrenteFisica;
    private JButton btPoupancaFisica;
    private JButton btCorrenteJuridica;

    JanelaCadastro() {

        pnDados = new JPanel();
        pnBotoes = new JPanel();

        this.setLayout(new BorderLayout());

        this.add(pnDados, BorderLayout.NORTH);
        this.add(pnBotoes, BorderLayout.SOUTH);

        pnDados.setLayout(new GridLayout(8, 2));
        pnBotoes.setLayout(new GridLayout(2, 2));

        JRadioButton rbCpf = new JRadioButton("Fisica");
        JRadioButton rbCnpj = new JRadioButton("Juridica");

        JLabel lbNome = new JLabel("Nome:");
        JLabel lbCpf = new JLabel("Cpf:");
        JLabel lbCnpj = new JLabel("Cnpj:");
        JLabel lbSenha = new JLabel("Senha:");
        JLabel lbNumero = new JLabel("Numero:");
        JLabel lbSaldo = new JLabel("Saldo:");

        tfNome = new JTextField(40);
        tfCpf = new JTextField(11);
        tfCnpj = new JTextField(14);
        tfSenha = new JTextField(6);
        tfNumero = new JTextField(8);
        tfSaldo = new JTextField(10000);

        pnDados.add(rbCnpj);pnDados.add(rbCpf);
        pnDados.add(lbNome);pnDados.add(tfNome);
        pnDados.add(lbCpf);pnDados.add(tfCpf);
        pnDados.add(lbCnpj);pnDados.add(tfCnpj);
        pnDados.add(lbSenha);pnDados.add(tfSenha);
        pnDados.add(lbNumero);pnDados.add(tfNumero);
        pnDados.add(lbSaldo);pnDados.add(tfSaldo);


        btCorrenteFisica = new JButton("Corrente Pessoa Fisica");
        btPoupancaFisica = new JButton("Poupanca Pessoa Fisica");
        btCorrenteJuridica = new JButton("Corrente Pessoa Juridica");

        pnBotoes.add(btCorrenteFisica);
        pnBotoes.add(btPoupancaFisica);
        pnBotoes.add(btCorrenteJuridica);

        btCorrenteFisica.addActionListener(this);
        btPoupancaFisica.addActionListener(this);
        btCorrenteJuridica.addActionListener(this);

        this.setTitle("Cadastro Conta Cliente");
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        rbCpf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                tfCnpj.setEditable(false);
                btCorrenteJuridica.setEnabled(false);
                btPoupancaFisica.setEnabled(true);
                btCorrenteFisica.setEnabled(true);
                tfCpf.setEditable(true);
            }
        });

        rbCnpj.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                tfCpf.setEditable(false);
                btPoupancaFisica.setEnabled(false);
                btCorrenteFisica.setEnabled(false);
                tfCnpj.setEditable(true);
                btCorrenteJuridica.setEnabled(true);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btPoupancaFisica) {

            Cliente cliente = new PessoaFisica(tfNome.getText(), parseInt(tfSenha.getText()), parseInt(tfCpf.getText()));
            Conta conta = new ContaPopanca(cliente, parseInt(tfNumero.getText()), Double.parseDouble(tfSaldo.getText()));

            String login = JOptionPane.showInputDialog(null, "Numero Agencia", "Autenticação", 3);
            String loginSenha = JOptionPane.showInputDialog(null, "Senha Gerente", "Autenticação", 3);

            Banco.cadastroConta(login, loginSenha, conta);
        }

        if (e.getSource() == btCorrenteFisica) {

            Cliente cliente = new PessoaFisica(tfNome.getText(), parseInt(tfSenha.getText()), parseInt(tfCpf.getText()));
            Conta conta = new ContaCorrente(cliente, parseInt(tfNumero.getText()), Double.parseDouble(tfSaldo.getText()));

            String login = JOptionPane.showInputDialog(null, "Numero Agencia", "Autenticação", 3);
            String loginSenha = JOptionPane.showInputDialog(null, "Senha Gerente", "Autenticação", 3);

            Banco.cadastroConta(login, loginSenha, conta);
        }

        if (e.getSource() == btCorrenteJuridica) {

            Cliente cliente = new PessoaJuridica(tfNome.getText(), parseInt(tfSenha.getText()), parseInt(tfCnpj.getText()));
            Conta conta = new ContaCorrente(cliente, parseInt(tfNumero.getText()), Double.parseDouble(tfSaldo.getText()));

            String login = JOptionPane.showInputDialog(null, "Numero Agencia", "Autenticação", 3);
            String loginSenha = JOptionPane.showInputDialog(null, "Senha Gerente", "Autenticação", 3);

            Banco.cadastroConta(login, loginSenha, conta);
        }
    }

}
