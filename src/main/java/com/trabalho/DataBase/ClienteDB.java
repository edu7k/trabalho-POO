package com.trabalho.DataBase;

import java.util.ArrayList;
import java.util.List;

import com.trabalho.Model.Cliente;


public class ClienteDB {
    private List<Cliente> clientes;

    public ClienteDB(){
        clientes = new ArrayList<>();
    }

    public List<Cliente> GetClientes(){

        return clientes;
    }

    public void addCliente(Cliente cliente){
        clientes.add(cliente);
        System.out.println("Cliente Adicionado");
    };

    public void RemoveCliente(int id){
        for(Cliente cliente : clientes){
            if(cliente.Id == id)
                clientes.remove(cliente);
        }

        System.out.println("Cliente Removido");

    }

    
}
