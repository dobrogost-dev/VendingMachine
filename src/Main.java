import java.io.*;

public class Main {
    public static void main(String[] args) {
        /*String[] allergens = {};
        Label label = new Label(allergens,500.0, 300.0);
        Product product = new Product("Pawełek", 2.0, label);
        VendingMachine.addProduct(product);
        VendingMachine.showProducts();
        System.out.println(product.showFullInfo());*/
        String extentFile = "data.ser";
        VendingMachine.initialize(extentFile);
        try {
            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
            VendingMachine.writeExtent(out);
            out.close();
            var in = new ObjectInputStream(new FileInputStream(extentFile));
            VendingMachine.readExtent(in);
            in.close();
        } catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
    }
}