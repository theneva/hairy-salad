import javax.ejb.Stateless;
import javax.persistence.*;

import models.User;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
@Stateless(name = "SessionEJB")
@PersistenceContext
public class SessionBean
{
    private EntityManagerFactory factory;

    private EntityManager manager;

    private EntityTransaction transaction;

    public SessionBean()
    {
        this.factory = Persistence.createEntityManagerFactory("PUSalad");
        this.manager = factory.createEntityManager();
        this.transaction = manager.getTransaction();
    }

    public void persist(User user)
    {
        // Don't persist it twice.
        if (this.manager.find(User.class, user.getId()) != null)
        {
            return;
        }

        this.transaction.begin();

        manager.persist(user);

        this.transaction.commit();
    }

    public void update(User user)
    {
        this.transaction.begin();

        manager.persist(user);

        this.transaction.commit();
    }

    public User findUser(String id)
    {
        return this.manager.find(User.class, id);
    }
}
