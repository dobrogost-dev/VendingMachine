import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Label implements Serializable {
    /**
     * Atrybut powtarzalny
     */
    private String[] allergens;

    /**
     * Atrybuty proste
     */
    private double weight;
    private double kcal;
    /**
     * Atrybut opcjonalny
     */
    private Double alcoholPercent;
    public Label(String[] allergens, double weight, double kcal) {
        this.allergens = allergens;
        this.weight = weight;
        this.kcal = kcal;
    }

    /**
     * Przeciążenie
     */
    public Label(String[] allergens, double weight, double kcal, double alcoholPercent) {
        this.allergens = allergens;
        this.weight = weight;
        this.kcal = kcal;
        this.alcoholPercent = alcoholPercent;
    }

    /**
     * Atrybut pochodny
     */
    public String getAllergens() {
        StringBuilder result = new StringBuilder("");
        for (String allergen : allergens) {
            result.append(allergen + ";");
        }
        return result.toString();
    }
    public String getAlcoholIfExists() {
        return alcoholPercent == null ? "not applicable" : alcoholPercent.toString() + "%";
    }
    public double getWeight() {
        return weight;
    }

    public double getKcal() {
        return kcal;
    }

}
