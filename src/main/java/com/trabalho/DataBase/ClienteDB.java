package com.trabalho.DataBase;

import java.util.ArrayList;
import java.util.List;

import com.trabalho.Model.Cliente;


public class ClienteDB {
    private List<Cliente> clientes;

    public ClienteDB() {
        clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente cliente) {
        int id = clientes.size() + 1; // Gera o ID como a quantidade de elementos na lista + 1
        cliente.setId(id);
        clientes.add(cliente);
        System.out.println("Cliente Adicionado: " + cliente.getNome());
    }

    public void removeCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
        System.out.println("Cliente Removido");
    }

    
}
