import java.util.*;

abstract class Employee {
    protected String name;
    protected double salary;
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    abstract double bonus();
    String getName() { return name; }
}

class FullTime extends Employee {
    FullTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.10; }
}

class PartTime extends Employee {
    PartTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String n, double s) { super(n, s); }
    double bonus() { return 2000.0; }
}

public class Problem4 {
    static Employee create(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTime(name, salary);
            case "PARTTIME": return new PartTime(name, salary);
            default:         return new Intern(name, salary);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            double salary = sc.nextDouble();
            list.add(create(type, name, salary));
        }
        double total = 0;
        for (Employee e : list) {
            double b = e.bonus();
            total += b;
            System.out.printf("%s: %.2f%n", e.getName(), b);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
