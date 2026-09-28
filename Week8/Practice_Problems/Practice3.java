import java.util.*;

abstract class Delivery {
    protected double weight, distance;
    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }
    abstract double fee();
    abstract String label();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double w, double d) { super(w, d); }
    double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
    String label() { return "STANDARD"; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double w, double d) { super(w, d); }
    double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
    String label() { return "EXPRESS"; }
}

class InternationalDelivery extends Delivery {
    private double customsFee;
    InternationalDelivery(double w, double d, double customsFee) {
        super(w, d);
        this.customsFee = customsFee;
    }
    double fee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
    String label() { return "INTERNATIONAL"; }
}

public class Practice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double w = sc.nextDouble();
            double d = sc.nextDouble();
            switch (type) {
                case "STANDARD": list.add(new StandardDelivery(w, d)); break;
                case "EXPRESS":  list.add(new ExpressDelivery(w, d)); break;
                default:         list.add(new InternationalDelivery(w, d, sc.nextDouble()));
            }
        }
        double total = 0;
        for (Delivery d : list) {
            double f = d.fee();
            total += f;
            System.out.printf("%s: %.2f%n", d.label(), f);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
