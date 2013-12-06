import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import models.SaladComponent;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
@Stateless(name = "SaladComponentEJB")
@PersistenceContext
public class SaladComponentBean
{
    private EntityManagerFactory factory;

    private EntityManager manager;

    private EntityTransaction transaction;

    public SaladComponentBean()
    {
        this.factory = Persistence.createEntityManagerFactory("PUSalad");
        this.manager = factory.createEntityManager();
        this.transaction = manager.getTransaction();
    }



    public List<SaladComponent> getSaladComponents()
    {
        return manager.createQuery("select c from SaladComponent c").getResultList();
    }
}
