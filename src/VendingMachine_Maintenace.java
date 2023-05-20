import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VendingMachine_Maintenace {
    private Map<VendingMachine, Set<Maintenace_Technician>> VMM;
    public VendingMachine_Maintenace() {
        VMM = new HashMap<>();
    }
    public void assign(Maintenace_Technician mTechnician, VendingMachine vendingMachine) throws Exception {
        Set<Maintenace_Technician> set = VMM.get(vendingMachine);
        if (set == null) {
            set = new HashSet<>();
            VMM.put(vendingMachine, set);
        }
        set.add(mTechnician);
        mTechnician.addVMM(this);
        vendingMachine.addVMM(this);
    }
    public void showInfo() {
        for (Map.Entry<VendingMachine, Set<Maintenace_Technician>> entry : VMM.entrySet()) {
            System.out.print("Vending Machine: " + entry.getKey());
            System.out.print(" Technicians: " + entry.getValue() + "\n");
        }
    }
}
