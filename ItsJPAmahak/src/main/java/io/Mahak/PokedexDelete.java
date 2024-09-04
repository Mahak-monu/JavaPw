package io.Mahak;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PokedexDelete {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MAHAKDASHORE");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        ItsPokemon p = entityManager.find(ItsPokemon.class ,"pokemon");
        if(p!=null) {
            entityTransaction.begin();
            entityManager.remove(p);
            entityTransaction.commit();
        }
        else {
            System.out.println("does not exits");
        }
    }
}
