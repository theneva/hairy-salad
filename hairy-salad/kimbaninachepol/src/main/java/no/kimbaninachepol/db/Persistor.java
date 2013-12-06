package no.kimbaninachepol.db;

import no.kimbaninachepol.models.Salad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
public class Persistor
{
    public Persistor()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUSalad");

        EntityManager manager = emf.createEntityManager();

        manager.getTransaction().begin();

        Salad someSalad = new Salad();
//        someSalad.setSaladId(101);

        manager.persist(someSalad);

        manager.getTransaction().commit();
    }

    public static void main(String[] args)
    {
        new Persistor();
    }
}
