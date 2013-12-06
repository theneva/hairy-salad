import java.util.List;

import javax.ejb.Stateless;

import models.Salad;
import models.SaladComponent;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
@Stateless(name = "PriceCalculatorEJB")
public class PriceCalculatorBean {
    public PriceCalculatorBean() {
    }

    /**
     * Calculates the price of a salad.
     * @param salad the salad.
     * @return the price.
     */
    public int calculatePrice(Salad salad)
    {
        int sum = 0;

        List<SaladComponent> components = salad.getComponents();

        // Accumulate the sum.
        for (SaladComponent component : components) {
            sum += component.getPrice();
        }

        return sum;
    }
}
