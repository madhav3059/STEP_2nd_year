// HomeApplianceEnergyReport.java
import java.util.Locale;
import java.util.Scanner;

interface SaverMode {
}

abstract class Appliance {
    protected final double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double powerWatts();

    final double units(boolean saver) {
        double energy = powerWatts() * hours / 1000.0;
        return saver ? energy * 0.75 : energy;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) { super(hours); }
    double powerWatts() { return 150; }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) { super(hours); }
    double powerWatts() { return 1500; }
}

class Television extends Appliance {
    Television(double hours) { super(hours); }
    double powerWatts() { return 100; }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) { super(hours); }
    double powerWatts() { return 500; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] types = new String[n];
        boolean[] saverRequested = new boolean[n];
        Appliance[] appliances = new Appliance[n];

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            double hours = sc.nextDouble();

            switch (types[i]) {
                case "FRIDGE": appliances[i] = new Fridge(hours); break;
                case "AC": appliances[i] = new AirConditioner(hours); break;
                case "TV": appliances[i] = new Television(hours); break;
                case "WASHER": appliances[i] = new WashingMachine(hours); break;
                default: throw new IllegalArgumentException("Unknown appliance: " + types[i]);
            }

            if (sc.hasNext("SAVER")) {
                sc.next();
                saverRequested[i] = true;
            }
        }

        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            Appliance appliance = appliances[i];

            if (saverRequested[i] && !(appliance instanceof SaverMode)) {
                System.out.println(types[i] + ": saver mode not supported");
                continue;
            }

            double units = appliance.units(saverRequested[i]);
            double cost = units * 8;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", types[i], units, cost);
            totalCost += cost;
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
