import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine implements Serializable {
    public int MAX_CAPACITY = 500;
    public int current_amount = 0;
    /*
    Asocjacja zwykła
    */
    private List<Product> products = new ArrayList<>();
    public void addProduct(Product product) {
        if (current_amount < MAX_CAPACITY) {
            product.setVendingMachine(this);
            products.add(product);
            current_amount++;
        } else {
            System.out.println("Capacity exceded, remove other products");
        }
    }
    public void removeProduct(int id) {
        if (id > 0 && id < products.size() + 1) {
            products.remove(id - 1);
            current_amount--;
            System.out.println("Product removed succesfully");
        } else {
            System.out.println("Wrong id");
        }
    }
    public void showProducts() {
        if (products.size() == 0) {
            System.out.println("None");
        }
        for(int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + ". " + products.get(i));
        }
    }
    public void showProductsSpecified() {
        if (products.size() == 0) {
            System.out.println("None");
        }
        for(int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + ". " + products.get(i).showFullInfo());
        }
    }
    public void initialize(String extentFile) {
        try {
            var in = new ObjectInputStream(new FileInputStream(extentFile));
            products = (ArrayList<Product>) in.readObject();
            current_amount = products.size();
            in.close();
            System.out.println("Vending Machine state loaded");
        } catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
    }
    public void save(String extentFile) {
        try {
            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
            out.writeObject(products);
            out.close();
            System.out.println("Vending Machine state saved");
        } catch (IOException e) { e.printStackTrace(); }
    }
}
