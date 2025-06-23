// Electric interface
interface Electric {
    void chargeBattery();
}

// Internal Combustion interface
interface InternalCombustion {
    void fillGas();
}

// Hybrid class implementing both interfaces
class Hybrid implements Electric, InternalCombustion {
    String attribute1 = "defaultValue";
    String attribute2;

    @Override
    public void chargeBattery() {
        System.out.println("Charging battery...");
    }

    @Override
    public void fillGas() {
        System.out.println("Filling gas...");
    }
}

// HybridVehicle class extending Hybrid
class HybridVehicle extends Hybrid {
    protected String carname;

    public HybridVehicle(String carname) {
        this.carname = carname;
    }

    public String getCarName() {
        return carname;
    }
}

// HybridSedan class
class HybridSedan extends HybridVehicle {
    public HybridSedan(String carname) {
        super(carname);
    }

    @Override
    public String getCarName() {
        return "Hybrid Sedan: " + carname;
    }
}

// HybridPickup class
class HybridPickup extends HybridVehicle {
    public HybridPickup(String carname) {
        super(carname);
    }

    @Override
    public String getCarName() {
        return "Hybrid Pickup: " + carname;
    }
}

// Carwash class
class Carwash {
    public void wash(HybridVehicle vehicle) {
        System.out.println("Washing vehicle: " + vehicle.getCarName());
    }

    public void chargeBattery() {
        System.out.println("Carwash charging battery...");
    }

    public void fillGas() {
        System.out.println("Carwash filling gas...");
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        // Create a Hybrid Sedan
        HybridSedan sedan = new HybridSedan("Toyota Prius");
        sedan.chargeBattery();
        sedan.fillGas();
        System.out.println(sedan.getCarName());

        System.out.println();

        // Create a Hybrid Pickup
        HybridPickup pickup = new HybridPickup("BYD Shark");
        pickup.chargeBattery();
        pickup.fillGas();
        System.out.println(pickup.getCarName());

        System.out.println();

        // Carwash service
        Carwash carwash = new Carwash();
        carwash.wash(sedan);
        carwash.wash(pickup);
    }
}
