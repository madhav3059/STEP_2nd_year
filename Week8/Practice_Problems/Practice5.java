import java.util.*;

abstract class Journey {
    protected double distance;
    Journey(double distance) { this.distance = distance; }
    abstract double fare();
    abstract String label();
}

class BusJourney extends Journey {
    BusJourney(double d) { super(d); }
    double fare() { return Math.min(10.0, 2 + 0.10 * distance); }
    String label() { return "BUS"; }
}

class TrainJourney extends Journey {
    TrainJourney(double d) { super(d); }
    double fare() { return 3 + 0.15 * distance; }
    String label() { return "TRAIN"; }
}

class MetroJourney extends Journey {
    private double peakFactor;
    MetroJourney(double d, double peakFactor) {
        super(d);
        this.peakFactor = peakFactor;
    }
    double fare() { return (1.5 + 0.20 * distance) * peakFactor; }
    String label() { return "METRO"; }
}

public class Practice5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double d = sc.nextDouble();
            switch (type) {
                case "BUS":   list.add(new BusJourney(d)); break;
                case "TRAIN": list.add(new TrainJourney(d)); break;
                default:      list.add(new MetroJourney(d, sc.nextDouble()));
            }
        }
        double total = 0;
        for (Journey j : list) {
            double f = j.fare();
            total += f;
            System.out.printf("%s: %.2f%n", j.label(), f);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
