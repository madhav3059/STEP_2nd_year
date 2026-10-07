import java.util.Locale;
import java.util.Scanner;

abstract class StaffMember {
    private final String name;

    StaffMember(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private final double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private final double hours;
    private final double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculatePay() {
        return Math.min(hours, 40) * rate
                + Math.max(0, hours - 40) * rate * 1.5;
    }
}

class Intern extends StaffMember {
    private final double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StaffMember[] staff = new StaffMember[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "FULLTIME":
                    staff[i] = new FullTimeStaff(name, sc.nextDouble());
                    break;
                case "HOURLY":
                    staff[i] = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
                    break;
                case "INTERN":
                    staff[i] = new Intern(name, sc.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown staff type: " + type);
            }
        }

        double total = 0;
        for (StaffMember member : staff) {
            double pay = member.calculatePay();
            System.out.printf("%s: %.2f%n", member.getName(), pay);
            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
