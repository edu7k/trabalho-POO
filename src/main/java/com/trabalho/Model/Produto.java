package com.trabalho.Model;

public class Produto {
    public int Id;
    public String Nome;
    public double Preco;
    public int Quantidade;

    public Produto(String Nome, double Preco, int Quantidade) {
        this.Nome = Nome;
        this.Preco = Preco;
        this.Quantidade = Quantidade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    
}
