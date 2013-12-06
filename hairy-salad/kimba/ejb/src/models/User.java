package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
@Entity
public class User
{
    @Id
    private String id;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Salad> salads;

    public User()
    {
        this.salads = new ArrayList<>();
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public List<Salad> getSalads()
    {
        return salads;
    }

    public void setSalads(List<Salad> salads)
    {
        this.salads = salads;
    }

    @Override
    public String toString()
    {
        return "User{" + "id='" + id + '\'' + ", salads=" + salads + '}';
    }
}
