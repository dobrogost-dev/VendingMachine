import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    public Menu() {
        scanner = new Scanner(System.in);
    }
    public void process(String extentFile) {
        String action = scanner.nextLine();
        switch (action) {
            case "1":
                break;
            case "2":
                remove(scanner);
                break;
            case "3":
                System.out.println("Products in the vending machine:");
                VendingMachine.showProducts();
                break;
            case "4":
                VendingMachine.save(extentFile);
                break;
            case "5":
                VendingMachine.initialize(extentFile);
                break;
            case "6": System.exit(0);
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
                4. Save configuration
                5. Load configuration
                6. Exit
                *************************
                """);
    }
    public static void remove(Scanner scanner) {
        System.out.println("Which product do you want to remove?");
            VendingMachine.showProducts();
            int input = scanner.nextInt();
            VendingMachine.removeProduct(input);
        }
}
