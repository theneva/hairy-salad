package no.kimbaninachepol.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
@Entity
public class Salad
{
    @Id
    @GeneratedValue
    private int saladId;



    public int getSaladId()
    {
        return saladId;
    }

    public void setSaladId(int saladId)
    {
        this.saladId = saladId;
    }

    @Override
    public String toString()
    {
        return "Salad{saladId=" + saladId + '}';
    }

    public static void main(String[] args) {
        Salad s = new Salad();
        s.setSaladId(12);

        System.out.println(s);
    }
}
