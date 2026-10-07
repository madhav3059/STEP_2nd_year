// CityCabFareMeter.java
import java.util.Locale;
import java.util.Scanner;

interface NightService {
}

abstract class Cab {
    protected final double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double ratePerKm();

    final double dayFare() {
        return Math.max(100, km * ratePerKm());
    }

    final double fare(boolean night) {
        double fare = dayFare();
        return night ? fare * 1.2 : fare;
    }
}

class MiniCab extends Cab {
    MiniCab(double km) { super(km); }
    double ratePerKm() { return 10; }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) { super(km); }
    double ratePerKm() { return 14; }
}

class SuvCab extends Cab implements NightService {
    SuvCab(double km) { super(km); }
    double ratePerKm() { return 18; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] types = new String[n];
        String[] times = new String[n];
        Cab[] cabs = new Cab[n];

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            double km = sc.nextDouble();
            times[i] = sc.next();

            switch (types[i]) {
                case "MINI": cabs[i] = new MiniCab(km); break;
                case "SEDAN": cabs[i] = new SedanCab(km); break;
                case "SUV": cabs[i] = new SuvCab(km); break;
                default: throw new IllegalArgumentException("Unknown cab: " + types[i]);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            boolean night = times[i].equals("NIGHT");

            if (night && !(cabs[i] instanceof NightService)) {
                System.out.println(types[i] + ": night service not available");
            } else {
                double fare = cabs[i].fare(night);
                System.out.printf("%s: %.2f%n", types[i], fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
