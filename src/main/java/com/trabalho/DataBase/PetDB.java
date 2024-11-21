package com.trabalho.DataBase;

import java.util.ArrayList;
import java.util.List;

import com.trabalho.Model.Cliente;
import com.trabalho.Model.Pet;


public class PetDB {
    public List<Pet> Pets;

     public PetDB() {
        Pets = new ArrayList<>();
    }

    public List<Pet> getPets() {
        return Pets;
    }

    public void addPet(Pet pet) {
        int id = Pets.size() + 1; // Gera o ID como a quantidade de elementos na lista + 1
        pet.setId(id);
        Pets.add(pet);
        System.out.println("Pet Adicionado: " + pet.getNome());
    }

    public void removePet(int id) {
        Pets.removeIf(pet -> pet.getId() == id);
        System.out.println("Pet Removido");
    }


    
}
