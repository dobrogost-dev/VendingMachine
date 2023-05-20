import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine implements Serializable {
    public String serial_number;
    private Location location;
    private List<Product> products;
    private List<VendingMachine_Maintenace> VMM;
    public VendingMachine(String serial_number) {
        this.serial_number = serial_number;
        products = new ArrayList<>();
        VMM = new ArrayList<>();
    }

    public void addProduct(Product product) {
        product.setVendingMachine(this);
        products.add(product);
    }
    public void addLocation(Location location) {
        this.location = location;
    }
    public void removeProduct(int id) {
        if (id > 0 && id < products.size() + 1) {
            products.remove(id - 1);
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
        System.out.println("Showing products for: " + serial_number);
        for (Product product : products) {
            product.showFullInfo();
        }
    }
    public void addVMM(VendingMachine_Maintenace VMM){
        this.VMM.add(VMM);
    }
    @Override
    public String toString() {
        return serial_number;
    }
}
