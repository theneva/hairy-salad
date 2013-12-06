import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.Salad;
import models.SaladComponent;
import models.User;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
@ManagedBean
@SessionScoped
public class UserController
{
    @EJB
    private SessionBean sessionBean;

    // The salad components, either checked or unchecked.
    private Map<SaladComponent, Boolean> saladComponentsUsed;

    /** The ID of the user. */
    private String id;

    public UserController()
    {
        this.saladComponentsUsed = new HashMap<>();
    }

    public String goToSalads()
    {
        User user = new User();
        user.setId(this.id);

        this.sessionBean.persist(user);

        return "salads?faces-redirect=true";
    }

    public String goBackToSalads()
    {
        return "salads?faces-redirect=true";
    }

    public List<Salad> getSalads()
    {
        return this.sessionBean.findUser(this.id).getSalads();
    }

    public String saveSalad()
    {
        List<SaladComponent> used = new ArrayList<>();

        for (Map.Entry<SaladComponent, Boolean> entry : saladComponentsUsed.entrySet())
        {
            if (entry.getValue()) // checked
            {
                used.add(entry.getKey());
            }
        }

        if (used.size() < 4) return "salads"; // TODO worst validation ever.

        Salad newSalad = new Salad();
        newSalad.setComponents(used);

        User user = this.sessionBean.findUser(this.id);
        user.getSalads().add(newSalad);

        this.sessionBean.update(user);

        return "created?faces-redirect=true";
    }

    public Map<SaladComponent, Boolean> getSaladComponentsUsed()
    {
        return saladComponentsUsed;
    }

    public void setSaladComponentsUsed(Map<SaladComponent, Boolean> saladComponentsUsed)
    {
        this.saladComponentsUsed = saladComponentsUsed;
    }

    public SessionBean getSessionBean()
    {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean)
    {
        this.sessionBean = sessionBean;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
