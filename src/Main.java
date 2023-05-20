public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Asocjacja zwykła
         */
        System.out.println("Asocjacja zwykła:");
        VendingMachine vendingMachine = new VendingMachine("Z2C4C-C13C");
        Product product1 = new Product("Grzesiek", 4.0);
        Product product2 = new Product("Pawełek", 5.0);
        //metoda addProduct automatycznie tworzy asocjacje w obie strony
        vendingMachine.addProduct(product1);
        vendingMachine.addProduct(product2);
        //Wyświetlenie produktów
        vendingMachine.showProductsSpecified();
        /*
        Kompozycja
         */
        System.out.println("Kompozycja:");
        //Etykiety nie da się stworzyć, powstaje ona jedynie poprzez
        //przekazanie produktu jako argument metodzie klasowej Label,
        Label.assignLabel(product1, new String[] {"orzechy", "kakao" }, 40.0,200.0,0.0);
        Label.assignLabel(product2, new String[] {"mleko", "kakao" }, 30.0,210.0,0.0);
        //Wyświetlenie produktów
        vendingMachine.showProductsSpecified();
        /*
        Asocjacja kwalifikowana
         */
        System.out.println("Asocjacja kwalifikowana:");
        Location location = new Location(1, "Mokotów");
        location.addVendingMachine(vendingMachine);
        location.getVendingMachine(vendingMachine.serial_number).showProductsSpecified();
        /*
        Asocjacja z atrybutem
         */
        System.out.println("Asocjacja z atrybutem:");
        VendingMachine vendingMachine2 = new VendingMachine("MV20V-1X21");
        Maintenace_Technician mTechnician1 = new Maintenace_Technician(1,"Jan Kowalski", 43, 4300);
        Maintenace_Technician mTechnician2 = new Maintenace_Technician(2,"Andrzej Nowak", 55, 4500);
        Maintenace_Technician mTechnician3 = new Maintenace_Technician(3,"Janusz Kamiński", 51, 4200);
        Maintenace_Technician mTechnician4 = new Maintenace_Technician(4,"Mateusz Bednarek", 33, 4150);
        VendingMachine_Maintenace VMM = new VendingMachine_Maintenace();
        VMM.assign(mTechnician1, vendingMachine);
        VMM.assign(mTechnician2, vendingMachine);
        VMM.assign(mTechnician3, vendingMachine);
        VMM.assign(mTechnician1, vendingMachine2);
        VMM.assign(mTechnician4, vendingMachine2);
        VMM.showInfo();

    }
}