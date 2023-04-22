public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        String extentFile = "data.ser";
        while (true) {
            menu.display();
            menu.process(extentFile);
        }
    }
}