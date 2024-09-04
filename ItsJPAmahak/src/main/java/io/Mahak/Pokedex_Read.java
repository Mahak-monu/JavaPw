package io.Mahak;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Pokedex_Read {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MAHAKDASHORE");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ItsPokemon p = entityManager.find(ItsPokemon.class , "pikachu");
        if(p!=null)
        System.out.println(p);
        else
            System.out.println("entry not exist");
    }
}
