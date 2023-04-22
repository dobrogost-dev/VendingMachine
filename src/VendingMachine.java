import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine implements Serializable {
    /**
     * Atrybut klasowy
     */
    public static int MAX_CAPACITY = 500;
    public static int current_amount = 0;
    /**
     * Ekstensja klasy
     */
    private static List<Product> extent = new ArrayList<>();
    public static void addProduct(Product product) {
        if (current_amount < MAX_CAPACITY) {
            extent.add(product);
            current_amount++;
        }
    }
    public static void removeProduct(int id) {
        if (id > 0 && id < extent.size() + 1) {
            extent.remove(id - 1);
            current_amount--;
            System.out.println("Product removed succesfully");
        } else {
            System.out.println("Wrong id");
        }
    }
    public static void showProducts() {
        if (extent.size() == 0) {
            System.out.println("None");
        }
        for(int i = 0; i < extent.size(); i++) {
            System.out.println(i + 1 + ". " + extent.get(i));
        }
    }
    public static void showProductsSpecified() {
        if (extent.size() == 0) {
            System.out.println("None");
        }
        for(int i = 0; i < extent.size(); i++) {
            System.out.println(i + 1 + ". " + extent.get(i).showFullInfo());
        }
    }


    /**
     * Metoda Klasowa
     */
    public static void initialize(String extentFile) {
        try {
            var in = new ObjectInputStream(new FileInputStream(extentFile));
            VendingMachine.readExtent(in);
            in.close();
            System.out.println("Vending Machine state loaded");
        } catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
    }
    public static void save(String extentFile) {
        try {
            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
            VendingMachine.writeExtent(out);
            out.close();
            System.out.println("Vending Machine state saved");
        } catch (IOException e) { e.printStackTrace(); }
    }
    public static void changeMaxCapacity(int capacity) {
        MAX_CAPACITY = capacity;
    }
    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }
    public static void readExtent(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        extent = (ArrayList<Product>) stream.readObject();
        current_amount = extent.size();
    }
}
