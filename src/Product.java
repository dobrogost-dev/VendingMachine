import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    /**
     * Atrybut prosty
     */
    private String name;
    private double price;
    /**
     * Atrybut złożony
     */
    private Label label;
    public Product(String name, double price, Label label) {
        this.price = price;
        this.name = name;
        this.label = label;
    }
    public String showFullInfo() {
        return this.toString() +  " Weight: " + label.getWeight() + "g Kcal: " + label.getKcal()
                + " Alcohol: " + label.getAlcoholIfExists() + " Allergens: " +  label.getAllergens();
    }
    /**
     *Przesłonięcie
     */
    @Override
    public String toString() {
        return name + ": " + price + "zł.";
    }
}
