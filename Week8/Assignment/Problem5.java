import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    protected String name;
    protected LocalDate start;
    Plan(String name, LocalDate start) {
        this.name = name;
        this.start = start;
    }
    abstract int validityDays();
    LocalDate renewalDate() { return start.plusDays(validityDays()); }
    String getName() { return name; }
}

class BasicPlan extends Plan {
    BasicPlan(String n, LocalDate s) { super(n, s); }
    int validityDays() { return 30; }
}

class StandardPlan extends Plan {
    StandardPlan(String n, LocalDate s) { super(n, s); }
    int validityDays() { return 90; }
}

class PremiumPlan extends Plan {
    PremiumPlan(String n, LocalDate s) { super(n, s); }
    int validityDays() { return 365; }
}

public class Problem5 {
    static Plan create(String type, String name, LocalDate start) {
        switch (type) {
            case "BASIC":    return new BasicPlan(name, start);
            case "STANDARD": return new StandardPlan(name, start);
            default:         return new PremiumPlan(name, start);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            list.add(create(type, name, start));
        }
        for (Plan p : list) {
            System.out.println(p.getName() + ": " + p.renewalDate());
        }
    }
}
