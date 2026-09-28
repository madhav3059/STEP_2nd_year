import java.util.*;

abstract class Vehicle {
    protected int hours;
    Vehicle(int hours) { this.hours = hours; }
    abstract double charge();
    abstract String label();
}

class Bike extends Vehicle {
    Bike(int h) { super(h); }
    double charge() { return 10.0 * hours; }
    String label() { return "BIKE"; }
}

class Car extends Vehicle {
    Car(int h) { super(h); }
    double charge() { return 30.0 + 20.0 * (hours - 1); }
    String label() { return "CAR"; }
}

class Truck extends Vehicle {
    Truck(int h) { super(h); }
    double charge() { return Math.max(100.0, 50.0 * hours); }
    String label() { return "TRUCK"; }
}

public class Problem2 {
    static Vehicle create(String type, int hours) {
        switch (type) {
            case "BIKE": return new Bike(hours);
            case "CAR":  return new Car(hours);
            default:     return new Truck(hours);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();
            list.add(create(type, hours));
        }
        double total = 0;
        for (Vehicle v : list) {
            double c = v.charge();
            total += c;
            System.out.printf("%s: %.2f%n", v.label(), c);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
