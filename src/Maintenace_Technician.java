import java.util.ArrayList;
import java.util.List;

public class Maintenace_Technician {
    private int id;
    private String name;
    private int age;
    private double salary;
    private List<VendingMachine_Maintenace> VMM;

    public Maintenace_Technician(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        VMM = new ArrayList<>();
    }
    public void addVMM(VendingMachine_Maintenace VMM){
        this.VMM.add(VMM);
    }
    @Override
    public String toString() {
        return name + " lat " + age + " zarabia " + salary + "zł";
    }
}
