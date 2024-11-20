package com.trabalho.Model;

import java.util.List;

public class Cliente {
    public int Id;
    public String Nome;
    public String Telefone;
    public String Endereco;
    public List<Pet> Pets;

    public void CadastraCliente(){

        System.out.println("Digite o nome do cliente: ");
    }
}
