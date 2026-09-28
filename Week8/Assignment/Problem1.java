import java.util.*;

abstract class Customer {
    protected double amount;
    Customer(double amount) { this.amount = amount; }
    abstract double finalAmount();
    abstract String label();
}

class Student extends Customer {
    Student(double a) { super(a); }
    double finalAmount() { return amount * 0.90; }
    String label() { return "STUDENT"; }
}

class Staff extends Customer {
    Staff(double a) { super(a); }
    double finalAmount() { return amount * 0.95; }
    String label() { return "STAFF"; }
}

class Guest extends Customer {
    Guest(double a) { super(a); }
    double finalAmount() { return amount + 10; }
    String label() { return "GUEST"; }
}

public class Problem1 {
    static Customer create(String type, double amount) {
        switch (type) {
            case "STUDENT": return new Student(amount);
            case "STAFF":   return new Staff(amount);
            default:        return new Guest(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amt = sc.nextDouble();
            list.add(create(type, amt));
        }
        double total = 0;
        for (Customer c : list) {
            double f = c.finalAmount();
            total += f;
            System.out.printf("%s: %.2f%n", c.label(), f);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
