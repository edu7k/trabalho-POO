package com.trabalho.DataBase;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.trabalho.Model.Produto;


public class ProdutoDB {
    private List<Produto> produtos;

    public ProdutoDB() {
        produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        int id = produtos.size() + 1; // Gera o ID como a quantidade de elementos na lista + 1
        produto.setId(id);
        produtos.add(produto);
        System.out.println("Produto Adicionado: " + produto.getNome());
    }

    public void removeProduto(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
        System.out.println("Produto Removido");
    }

    public void editarProduto(int id, String novoNome, double novoPreco, int novaQuantidade) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setNome(novoNome);
                produto.setPreco(novoPreco);
                produto.setQuantidade(novaQuantidade);
                System.out.println("Produto Editado: " + produto.getNome());
                return; // Sai do método após editar
            }
        }
        JOptionPane.showMessageDialog(null, "Funcionalidade de edição não implementada.");
    }

    
}
