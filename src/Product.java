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
    public Product(String name, double price) {
        this.price = price;
        this.name = name;
        this.vendingMachine = null;
    }
    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    public void setLabel(Label label) {
        this.label = label;
        label.addProduct(this);
    }
    public void showFullInfo() {
        String info = "Name: " + name + " Price: " + price + "zł";
        if (label == null) {
        } else {
            info += label.getInfo();
        }
        System.out.println(info);
    }
}
