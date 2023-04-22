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
    public static void removeProduct(Product product) {
        extent.remove(product);
        current_amount--;
    }
    public static void showProducts() {
        System.out.println("Products in the vending machine:");
        for(Product product : extent) {
            System.out.println(product);
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
        } catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
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
