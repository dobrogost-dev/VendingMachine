import java.util.ArrayList;
import java.util.List;

public class Maintenace_Technician {
    private int id;
    private String name;
    private int age;
    private double salary;
    private List<VendingMachine_Maintenace> VMM;
    public Maintenace_Technician() {
        VMM = new ArrayList<>();
    }
}
