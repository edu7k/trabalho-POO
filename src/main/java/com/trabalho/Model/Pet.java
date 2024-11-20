package com.trabalho.Model;



public class Pet {
    public String Nome;
    public int Id;
    public String Raca;
    public String Especie;
    public int Idade;
    public Cliente Dono;

    public Pet(int Id, Cliente Dono, String Especie, int Idade, String Nome, String Raca) {
        
        this.Id = Id;
        this.Dono = Dono;
        this.Especie = Especie;
        this.Idade = Idade;
        this.Nome = Nome;
        this.Raca = Raca;
    }
}
