package io.Mahak;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PokedexUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MAHAKDASHORE");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        ItsPokemon p = entityManager.find(ItsPokemon.class , "pikachu");
        if(p!=null){
            p.setPower(150);
            entityTransaction.begin();
            entityManager.persist(p);
            entityTransaction.commit();

        }
        else {
            System.out.println("entry does not exists");
        }

    }
}
