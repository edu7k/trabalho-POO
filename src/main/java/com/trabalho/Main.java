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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


import com.trabalho.DataBase.ClienteDB;
import com.trabalho.DataBase.PetDB;

import com.trabalho.Model.Cliente;
import com.trabalho.Model.Pet;
import com.trabalho.Model.Produto;
import com.trabalho.View.TelaProdutos;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginScreen());
    }
}



class LoginScreen extends JFrame {
    public LoginScreen() {
        setTitle("Tela de Login");
        setSize(600, 400);
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
                if (username.equals("") && password.equals("")) {
                    new MainScreen();  // Abre a tela do Dashboard
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

class MainScreen extends JFrame {
    public MainScreen() {
        setTitle("E & A PetShop");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Criação dos botões
        JButton btnClientes = new JButton("Clientes");
        JButton btnPets = new JButton("Pets");
        JButton btnProdutos = new JButton("Produtos");
        JButton btnAgendamentos = new JButton("Agendamentos");

        // Adicionando ActionListeners aos botões
        btnClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ClienteDashboard(); // Abre o dashboard de Clientes
            }
        });

        btnPets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PetsDashboard(); // Abre o dashboard de Pets
            }
        });

        btnProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaProdutos(); // Abre o dashboard de Produtos
            }
        });

        btnAgendamentos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AgendamentosDashboard(); // Abre o dashboard de Agendamentos
            }
        });

        // Layout dos botões
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1)); // 4 linhas, 1 coluna
        panel.add(btnClientes);
        panel.add(btnPets);
        panel.add(btnProdutos);
        panel.add(btnAgendamentos);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    
}

class ClienteDashboard extends JFrame {
    public ClienteDashboard() {
        ClienteDB clienteDB = new ClienteDB();
        // Adicionando alguns clientes para teste
        clienteDB.addCliente(new Cliente("Eduardo", "555-6666", "rua manga, 1152"));
        clienteDB.addCliente(new Cliente("Maria", "123-4567", "rua laranja, 123"));

        // Configuração da tabela
        String[] columnNames = {"ID", "Nome", "Telefone"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Cliente cliente : clienteDB.getClientes()) {
            Object[] rowData = {cliente.getId(), cliente.getNome(), cliente.getTelefone()};
            tableModel.addRow(rowData);
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
                new MainScreen(); // Abre a tela principal
            }
        });
        add(btnVoltar, BorderLayout.SOUTH);

        setTitle("Dashboard de Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }
}

 class PetsDashboard extends JFrame {
    public PetsDashboard() {
        PetDB petDB = new PetDB();
        // Adicionando alguns clientes para teste
        petDB.addPet(new Pet("Gato", 2, "Bartolomeu", "Laranja"));
        petDB.addPet(new Pet("Cachorro", 4, "Bruno", "Golden Retriever"));
    
        // Configuração da tabela
        String[] columnNames = {"ID", "Nome", "Especie", "Idade", "Raca"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        updateTableModel(tableModel, petDB);
    
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        /* 
        // Botões
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar um novo pet
                String nome = JOptionPane.showInputDialog("Nome do Produto:");
                String raca = JOptionPane.showInputDialog("Raça:");
                String especie = JOptionPane.showInputDialog("Especie:");
                String idade = JOptionPane.showInputDialog("Idade:");

                String donoId = JOptionPane.showInputDialog("Digite Id do Dono:");
                
                if (nome != null && precoStr != null && quantidadeStr != null) {
                    double preco = Double.parseDouble(precoStr);
                    int quantidade = Integer.parseInt(quantidadeStr);
                    Produto produto = new Produto(nome, preco, quantidade);
                    produtoDB.addProduto(produto);
                    updateTableModel(); // Atualiza a tabela
                }
            }
        });  
    */
        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para editar um pet selecionado
            }
        });
    
        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para remover um pet selecionado
            }
        });
    
        JButton btnAdicionarDono = new JButton("Adicionar Dono");
        btnAdicionarDono.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar um dono a um pet
            }
        });
    
        JPanel panelButtons = new JPanel();
        //panelButtons.add(btnCadastrar);
        panelButtons.add(btnEditar);
        panelButtons.add(btnRemover);
        panelButtons.add(btnAdicionarDono);
        add(panelButtons, BorderLayout.SOUTH);
    
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
                new MainScreen(); // Abre a tela principal
            }
        });
    
        add(btnVoltar, BorderLayout.NORTH);
        setTitle("Dashboard de Pets");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }
    
    private void updateTableModel(DefaultTableModel tableModel, PetDB petDB) {
        tableModel.setRowCount(0); // Limpa a tabela
        for (Pet pet : petDB.getPets()) {
            Object[] rowData = {pet.getId(), pet.getNome(), pet.getEspecie(), pet.getIdade(), pet.getRaca()};
            tableModel.addRow(rowData);
        }
    }
}






class AgendamentosDashboard extends JFrame{
    public AgendamentosDashboard() {
        ClienteDB clienteDB = new ClienteDB();
        // Adicionando alguns clientes para teste
        clienteDB.addCliente(new Cliente("Eduardo", "555-6666", "rua manga, 1152"));
        clienteDB.addCliente(new Cliente("Maria", "123-4567", "rua laranja, 123"));

        // Configuração da tabela
        String[] columnNames = {"ID", "Nome", "Telefone"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Cliente cliente : clienteDB.getClientes()) {
            Object[] rowData = {cliente.getId(), cliente.getNome(), cliente.getTelefone()};
            tableModel.addRow(rowData);
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
                new MainScreen(); // Abre a tela principal
            }
        });

        add(btnVoltar, BorderLayout.SOUTH);
        setTitle("Dashboard de Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
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

