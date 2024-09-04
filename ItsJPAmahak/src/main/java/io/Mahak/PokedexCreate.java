package io.Mahak;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PokedexCreate {
    public static void main(String[] args) {
        ItsPokemon p1 =new ItsPokemon();
        p1.setName("pikachu");
        p1.setType("electrical");
        p1.setPower(100);
      //  p1.setColor(Color.YELLOW);
        ItsPokemon p2 = new ItsPokemon();
        p2.setName("charizard");
        p2.setType("Fire");
        p2.setPower(200);
      //  p2.setColor(Color.CREAM);

        ItsPokemon p3 = new ItsPokemon();
        p3.setName("meowth");
        p3.setPower(80);
        p3.setType("Water");
    //    p3.setColor(Color.ORANGE);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MAHAKDASHORE");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);

        entityTransaction.commit();

    }

}
