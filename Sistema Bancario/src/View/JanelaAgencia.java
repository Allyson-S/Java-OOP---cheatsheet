package View;

import banco.Banco;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaAgencia extends JFrame implements ActionListener {

        private  JPanel pnDados;
        private  JPanel pnBotoes;

        private JTextField tfNumero;
        private JTextField tfGerente;

        private JButton btSalvar;

        JanelaAgencia() {
            pnDados = new JPanel();
            pnBotoes = new JPanel();

            this.setLayout(new BorderLayout());

            this.add(pnDados, BorderLayout.NORTH);
            this.add(pnBotoes, BorderLayout.SOUTH);

            pnDados.setLayout(new GridLayout(3, 1));
            pnBotoes.setLayout(new GridLayout(1, 1));

            JLabel lbNumero = new JLabel("Numero:");
            JLabel lbGerente = new JLabel("Senha Gerente:");

            tfNumero = new JTextField(15);
            tfGerente = new JTextField(10);

            pnDados.add(lbNumero);
            pnDados.add(tfNumero);
            pnDados.add(lbGerente);
            pnDados.add(tfGerente);

            btSalvar = new JButton("Salvar");

            pnBotoes.add(btSalvar);


            btSalvar.addActionListener(this);


            this.setTitle("Cadastro de Agencia");
            this.setSize(400, 250);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btSalvar) {
                Banco.cadastroAg(tfNumero.getText(), tfGerente.getText());
            }

        }

    }
