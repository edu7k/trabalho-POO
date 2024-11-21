package com.trabalho.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.trabalho.DataBase.ProdutoDB;
import com.trabalho.Model.Produto;

public class TelaProdutos extends JFrame{
    protected ProdutoDB produtoDB;
    protected  DefaultTableModel tableModel;
    protected JTable table;

    public TelaProdutos() {
        produtoDB = new ProdutoDB();
        // Adicionando alguns produtos para teste
        produtoDB.addProduto(new Produto("Ração", 5.00, 50));
        produtoDB.addProduto(new Produto("Bolinha", 3.00, 80));

        // Configuração da tabela
        String[] columnNames = {"ID", "Nome", "Preço UN.", "Quantidade Estoque"};
        tableModel = new DefaultTableModel(columnNames, 0);
        updateTable();

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Layout vertical

        JButton btnCadastrar = new JButton("Cadastrar Produto");
        JButton btnRemover = new JButton("Remover Produto");
        JButton btnEditar = new JButton("Editar Produto");
        JButton btnVender = new JButton("Realizar Venda");

        
        // Adicionando ações aos botões
        btnCadastrar.addActionListener((ActionEvent e) -> {
            // Lógica para cadastrar produto
            String nome = JOptionPane.showInputDialog("Nome do Produto:");
            String precoStr = JOptionPane.showInputDialog("Preço do Produto:");
            String quantidadeStr = JOptionPane.showInputDialog("Quantidade do Produto:");
            
            if (nome != null && precoStr != null && quantidadeStr != null) {
                double preco = Double.parseDouble(precoStr);
                int quantidade = Integer.parseInt(quantidadeStr);
                Produto produto = new Produto(nome, preco, quantidade);
                produtoDB.addProduto(produto);
                updateTable(); // Atualiza a tabela
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("ID do Produto a ser removido:");
                if (idStr != null) {
                    int id = Integer.parseInt(idStr);
                    produtoDB.removeProduto(id);
                    updateProductIds(); // Atualiza os IDs dos produtos restantes
                    updateTable(); // Atualiza a tabela
                }
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para editar produto (opcional)
                String idStr = JOptionPane.showInputDialog("ID do Produto a ser editado:");
                if (idStr != null) {
                    String nome = JOptionPane.showInputDialog("Nome do Produto:");
                    String precoStr = JOptionPane.showInputDialog("Preço do Produto:");
                    String quantidadeStr = JOptionPane.showInputDialog("Quantidade do Produto:");
                    int id = Integer.parseInt(idStr);
                    double preco = Double.parseDouble(precoStr);
                    int quantidade = Integer.parseInt(quantidadeStr);
                    
                    produtoDB.editarProduto(id, nome, preco, quantidade);
                    updateTable();
                    updateProductIds();
                }
            }
        });

        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para realizar venda (opcional)
                JOptionPane.showMessageDialog(null, "Funcionalidade de venda não implementada.");
            }
        });

        // Adicionando botões ao painel
        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnRemover);
        buttonPanel.add(btnEditar);
        buttonPanel.add(btnVender);

        // Adicionando o painel de botões à lateral
        add(buttonPanel, BorderLayout.WEST);

        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
                // new MainScreen(); // Descomente se houver uma tela principal
            }
        });

        add(btnVoltar, BorderLayout.SOUTH);
        setTitle("Dashboard de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }

    private void updateTable() {
        // Limpa a tabela antes de atualizar
        tableModel.setRowCount(0);
        for (Produto produto : produtoDB.getProdutos()) {
            Object[] rowData = {produto.getId(), produto.getNome(), "R$ " + produto.getPreco(), produto.getQuantidade()};
            tableModel.addRow(rowData);
        }
    }

    private void updateProductIds() {
        // Atualiza os IDs dos produtos restantes
        int newId = 1; // Começa a contagem de IDs a partir de 1
        for (Produto produto : produtoDB.getProdutos()) {
            produto.setId(newId++); // Atualiza o ID do produto
        }
    }
}


