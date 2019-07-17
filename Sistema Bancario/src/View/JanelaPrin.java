package View;

import banco.Banco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JanelaPrin extends JFrame implements ActionListener
{
    private JMenuItem cAgencia, cCliente, fConta, sair, infSobre, corrente, popanca;
    private JLabel status;
    private JDesktopPane areaTrab;

    public JanelaPrin()
    {
        super("Sistema banco.Banco");
        setSize(800,600);

        Container BarraMenus = new Container();
        BarraMenus.setLayout(null);

        JMenu cadMenu = new JMenu("Agencia"); // cria o primeiro menu

        cAgencia = new JMenuItem("Cadastrar Agencia"); // cria os sub-items
        cCliente = new JMenuItem("Cadastrar Cliente");
        fConta = new JMenuItem("Fechar Conta");
        sair = new JMenuItem("Sair");

        // adiciona os subitems ao menu
        cadMenu.add(cAgencia);
        cadMenu.add(cCliente);
        cadMenu.add(fConta);
        cadMenu.addSeparator();
        cadMenu.add(sair);

        // cria o segundo menu
        JMenu contaMenu = new JMenu("Contas");
        contaMenu.setMnemonic('R');

        corrente = new JMenuItem("Conta Corrente"); // cria os sub-items
        popanca = new JMenuItem("Conta Poupança");

        contaMenu.add(corrente);
        contaMenu.add(popanca);

        // cria o terceiro menu
        JMenu sobreMenu = new JMenu("Sobre");
        sobreMenu.setMnemonic('S');

        // cria os subitems do menu sobre
        infSobre = new JMenuItem("Informações");
        sobreMenu.add(infSobre);


        // cria a barra onde os menu irão ficar
        JMenuBar barra = new JMenuBar();
        barra.add(BarraMenus);
        setJMenuBar(barra); // configura a barra para este aplicativo
        barra.add(cadMenu);  barra.add(contaMenu);
        barra.add(sobreMenu);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

        areaTrab = new JDesktopPane();
        areaTrab.setBackground(new Color(192, 204, 224));

        Container Total = new Container();
        Total = getContentPane();
        Total.setLayout(new BorderLayout());

        Total.add("Center", areaTrab);
        Total.add("South", status = new JLabel("Informações...", JLabel.CENTER));

        // adiciona eventos para os ouvintes
        cAgencia.addActionListener(this);
        cCliente.addActionListener(this);
        fConta.addActionListener(this);
        sair.addActionListener(this);
        corrente.addActionListener(this);
        popanca.addActionListener(this);
        infSobre.addActionListener(this);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == cAgencia)
            new JanelaAgencia();

        if (e.getSource() == cCliente) {
            int flag = 0;

            String login = JOptionPane.showInputDialog(null, "Numero Agencia", "Login Gerente", 3);
            String loginSenha = JOptionPane.showInputDialog(null, "Senha Gerente", "Login Gerente", 3);

            flag = Banco.loginAgencia(login, loginSenha);

            if (flag == 1) {
                String msg = "Login Correto";
                JOptionPane.showMessageDialog(null, msg, "login", JOptionPane.PLAIN_MESSAGE);

                new JanelaCadastro();

            } else {
                String msg = "Login Incorreto";
                JOptionPane.showMessageDialog(null, msg, "login", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if (e.getSource() == fConta) {

            String login = JOptionPane.showInputDialog(null, "Numero Agencia", "Login Gerente", 3);
            String loginSenha = JOptionPane.showInputDialog(null, "Senha Gerente", "Login Gerente", 3);

            String loginCliente = JOptionPane.showInputDialog(null, "Numero da Conta", "Login Conta", 3);
            String loginSenhaCliente = JOptionPane.showInputDialog(null, "Senha da Conta", "Login Conta", 3);

            Banco.encerrarConta(login, loginSenha, loginCliente, loginSenhaCliente);
        }
        if (e.getSource() == sair)
            System.exit(0);


        if (e.getSource() == corrente)
            new JanelaCorrente();

        if (e.getSource() == popanca)
            new JanelaPoupanca();



    }

}
