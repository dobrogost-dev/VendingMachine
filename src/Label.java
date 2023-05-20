import java.io.Serializable;

public class Label implements Serializable {
    private String[] allergens;
    private double weight;
    private double kcal;
    private Double alcoholPercent;
    /*
    Kompozycja
     */
    private Product product;
    public Label(String[] allergens, double weight, double kcal) {
        this.allergens = allergens;
        this.weight = weight;
        this.kcal = kcal;
    }

    public Label(String[] allergens, double weight, double kcal, double alcoholPercent) {
        this.allergens = allergens;
        this.weight = weight;
        this.kcal = kcal;
        this.alcoholPercent = alcoholPercent;
    }

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
