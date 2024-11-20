package com.trabalho.DataBase;

import java.util.ArrayList;
import java.util.List;

import com.trabalho.Model.Pet;


public class PetDB {
    public List<Pet> Pets;

    public PetDB(){
        Pets = new ArrayList<>();
    }

    public List<Pet> GetPets(){

        return Pets;
    }

    public void addPet(Pet Pet){
        Pets.add(Pet);
        System.out.println("Pet Adicionado");
    };

    public void RemovePet(int id){
        for(Pet Pet : Pets){
            if(Pet.Id == id)
                Pets.remove(Pet);
        }

        System.out.println("Pet Removido");

    }

    public void EditPet(int id){
        for(Pet Pet : Pets){
            if(Pet.Id == id)
                Pets.remove(Pet);
        }
    
        System.out.println("Pet Removido");
    }

    
}
