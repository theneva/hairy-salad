import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import models.SaladComponent;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
@ManagedBean
public class SaladComponentController
{
    @EJB
    private SaladComponentBean saladComponentBean;

    public SaladComponentBean getSaladComponentBean()
    {
        return saladComponentBean;
    }

    public void setSaladComponentBean(SaladComponentBean saladComponentBean)
    {
        this.saladComponentBean = saladComponentBean;
    }

    public List<SaladComponent> getAllComponents()
    {
        return saladComponentBean.getSaladComponents();
    }

}
