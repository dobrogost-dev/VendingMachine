import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Label implements Serializable {
    private String[] allergens;
    private double weight;
    private double kcal;
    private Double alcoholPercent;
    /*
    Kompozycja
     */
    private List<Product> products;
    /*
    metoda assignLabel() jest jedynym sposobem na utworzenie obiektu label
    i automatycznie jest łączony z podanym produktem
     */
    public static void assignLabel(Product product, String[] allergens, double weight, double kcal, double alcoholPercent) {
        Label label = new Label(allergens, weight, kcal, alcoholPercent);
        product.setLabel(label);
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    /*
    Prywatny konstruktor sprawia, że poza klasą nie można utworzyć obiektu tego typu
     */
    private Label(String[] allergens, double weight, double kcal, double alcoholPercent) {
        products = new ArrayList<>();
        this.allergens = allergens;
        this.weight = weight;
        this.kcal = kcal;
        this.alcoholPercent = alcoholPercent;
    }
    public String getInfo() {
        StringBuilder result = new StringBuilder(" Allergens: ");
        for (String allergen : allergens) {
            result.append(allergen + ";");
        }
        result.append(" Weight: " + weight + " Kcal: " + kcal + " Alcohol: " + alcoholPercent);
        return result.toString();
    }
}
