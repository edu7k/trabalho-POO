package com.trabalho.Model;



public class Pet {
    public String Nome;
    public int Id;
    public String Raca;
    public String Especie;
    public int Idade;
    public Cliente Dono;

    public Pet(String Especie, int Idade, String Nome, String Raca) {
        
        this.Id = Id;
        this.Dono = Dono;
        this.Especie = Especie;
        this.Idade = Idade;
        this.Nome = Nome;
        this.Raca = Raca;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String Raca) {
        this.Raca = Raca;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public Cliente getDono() {
        return Dono;
    }

    public void setDono(Cliente Dono) {
        this.Dono = Dono;
    }
}
