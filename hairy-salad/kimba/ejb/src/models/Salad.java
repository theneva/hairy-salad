package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
@Entity
public class Salad
{
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    private List<SaladComponent> components;

    public Salad()
    {
        this.components = new ArrayList<>();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public List<SaladComponent> getComponents()
    {
        return components;
    }

    public void setComponents(List<SaladComponent> components)
    {
        this.components = components;
    }
}
