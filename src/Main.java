public class Main {
    public static void main(String[] args) {
        /*
        Asocjacja zwykła
         */
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
        //Etykiety nie da się stworzyć, powstaje ona jedynie poprzez
        //przekazanie produktu jako argument metodzie klasowej Label,
        Label.assignLabel(product1, new String[] {"orzechy", "kakao" }, 40.0,200.0,0.0);
        Label.assignLabel(product2, new String[] {"mleko", "kakao" }, 30.0,210.0,0.0);
        //Wyświetlenie produktów
        vendingMachine.showProductsSpecified();
    }
}