package com.trabalho;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginScreen());
    }
}



class LoginScreen extends JFrame {
    public LoginScreen() {
        setTitle("Tela de Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        
        JLabel userLabel = new JLabel("Usuário:");
        JTextField userText = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordText = new JPasswordField();
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                
                // Verifica se o usuário e a senha estão corretos
                if (username.equals("Eduardo") && password.equals("uems123")) {
                    new DashboardScreen();  // Abre a tela do Dashboard
                    dispose();              // Fecha a tela de login
                } else {
                    // Mostra uma mensagem de erro
                    JOptionPane.showMessageDialog(LoginScreen.this, "Usuário ou senha incorretos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);
        
        add(panel);
        setVisible(true);
    }
}

class DashboardScreen extends JFrame {
    public DashboardScreen() {
        setTitle("Tela Inicial (Dashboard)");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JTextArea textArea = new JTextArea("Resumo de agendamentos do dia, produtos em estoque, pets e clientes cadastrados.");
        textArea.setEditable(false);
        
        JButton petsButton = new JButton("Cadastrar Pets");
        petsButton.addActionListener(e -> new PetRegistrationScreen());
        
        JButton clientsButton = new JButton("Cadastrar Clientes");
        clientsButton.addActionListener(e -> new ClientRegistrationScreen());
        
        JPanel panel = new JPanel();
        panel.add(petsButton);
        panel.add(clientsButton);
        
        add(textArea, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
}

class PetRegistrationScreen extends JFrame {
    public PetRegistrationScreen() {
        setTitle("Cadastro de Pets");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        
        panel.add(new JLabel("Nome:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Idade:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Espécie:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Dono:"));
        panel.add(new JTextField());
        
        JButton saveButton = new JButton("Salvar");
        panel.add(saveButton);
        
        add(panel);
        setVisible(true);
    }
}

class ClientRegistrationScreen extends JFrame {
    public ClientRegistrationScreen() {
        setTitle("Cadastro de Clientes");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        
        panel.add(new JLabel("Nome:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Telefone:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Endereço:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Pets Vinculados:"));
        panel.add(new JTextField());
        
        JButton saveButton = new JButton("Salvar");
        panel.add(saveButton);
        
        add(panel);
        setVisible(true);
    }
}

// Você pode adicionar mais classes para as outras telas (Agendamento, Gerenciamento de Produtos, Histórico, Pagamento)

