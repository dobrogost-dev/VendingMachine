import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public Menu() {
    }
    public void process(String extentFile) {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        switch (action) {
            case "1":
                add();
                break;
            case "2":
                remove();
                break;
            case "3":
                System.out.println("Products in the vending machine:");
                VendingMachine.showProducts();
                break;
            case "4":
                System.out.println("Products in the vending machine with specified label:");
                VendingMachine.showProductsSpecified();
                break;
            case "5":
                VendingMachine.save(extentFile);
                break;
            case "6":
                VendingMachine.initialize(extentFile);
                break;
            case "7": System.exit(0);
                break;
        }
    }
    public void display() {
        System.out.println("""
                *************************
                Vending Machine
                1. Add product
                2. Remove product
                3. Show products
                4. Show products with specific data
                5. Save configuration
                6. Load configuration
                7. Exit
                *************************
                """);
    }
    public static void remove() {
            System.out.println("Which product do you want to remove?");
            VendingMachine.showProducts();
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            VendingMachine.removeProduct(input);
        }
        public static void add() {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is name of the product?");
                String name = scanner.nextLine();
                System.out.println("Does it have any allergens? Separate them by space, leave blank if none");
                String answer = scanner.nextLine();
                System.out.println("How much does it cost in zł?");
                double price = scanner.nextDouble();
                System.out.println("How much does it weight in grams?");
                double weight = scanner.nextDouble();
                System.out.println("How much kcal does it have?");
                double kcal = scanner.nextDouble();
                System.out.println("How much alcohol does it have? (Write 0 if none)");
                double alcoholPercent = scanner.nextDouble();
                String[] allergens = answer.split(" ");
                Label label = alcoholPercent == 0.0 ? new Label(allergens, weight, kcal)
                        : new Label(allergens, weight, kcal, alcoholPercent);
                Product product = new Product(name, price, label);
                VendingMachine.addProduct(product);
                System.out.println("Product added successfully");
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input");
            }
        }
}
