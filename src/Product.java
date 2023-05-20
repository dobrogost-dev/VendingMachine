import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private double price;
    /*
    Kompozycja
     */
    private Label label;
    /*
    Asocjacja zwykła
     */
    private VendingMachine vendingMachine;
    public Product(String name, double price, Label label) {
        this.price = price;
        this.name = name;
        this.label = label;
        this.vendingMachine = null;
    }
    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    public String showFullInfo() {
        return this +  " Weight: " + label.getWeight() + "g Kcal: " + label.getKcal()
                + " Alcohol: " + label.getAlcoholIfExists() + " Allergens: " +  label.getAllergens();
    }
    @Override
    public String toString() {
        return name + ": " + price + "zł.";
    }
}
