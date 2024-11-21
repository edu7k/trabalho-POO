package com.trabalho.Model;

import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private List<Pet> pets; // Supondo que você tenha uma classe Pet

    // Construtor
    public Cliente(String nome, String telefone, String endereco) {
        
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.pets = null; // Inicialize como null ou como uma nova lista, se preferir
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Pet> getPets() {
        return pets;
    }

    // Método para cadastrar cliente (pode ser melhorado)
    public void cadastraCliente() {
        System.out.println("Digite o nome do cliente: ");
        // Aqui você pode implementar a lógica para cadastrar o cliente
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
