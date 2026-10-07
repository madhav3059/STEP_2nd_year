// CollegeFeeCounter.java
import java.util.Locale;
import java.util.Scanner;

interface UsesCollegeBus {
}

abstract class Student {
    private final String name;

    Student(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract double baseFee();

    final double totalFee() {
        double fee = baseFee();
        if (this instanceof UsesCollegeBus) {
            fee += 12000;
        }
        return fee;
    }
}

class DayScholar extends Student implements UsesCollegeBus {
    DayScholar(String name) { super(name); }
    double baseFee() { return 40000; }
}

class Hosteller extends Student {
    Hosteller(String name) { super(name); }
    double baseFee() { return 40000 + 60000; }
}

class ScholarshipStudent extends Student implements UsesCollegeBus {
    ScholarshipStudent(String name) { super(name); }
    double baseFee() { return 20000; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR": students[i] = new DayScholar(name); break;
                case "HOSTELLER": students[i] = new Hosteller(name); break;
                case "SCHOLAR": students[i] = new ScholarshipStudent(name); break;
                default: throw new IllegalArgumentException("Unknown student type: " + type);
            }
        }

        double total = 0;
        for (Student student : students) {
            double fee = student.totalFee();
            System.out.printf("%s: %.2f%n", student.getName(), fee);
            total += fee;
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
