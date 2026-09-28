import java.util.*;

abstract class Room {
    protected int units;
    Room(int units) { this.units = units; }
    abstract double bill();
    abstract String label();
}

class SingleRoom extends Room {
    SingleRoom(int u) { super(u); }
    double bill() { return 8.0 * units; }
    String label() { return "SINGLE"; }
}

class SharedRoom extends Room {
    private int occupants;
    SharedRoom(int u, int occupants) {
        super(u);
        this.occupants = occupants;
    }
    double bill() { return (6.0 * units) / occupants; }
    String label() { return "SHARED"; }
}

class ACRoom extends Room {
    ACRoom(int u) { super(u); }
    double bill() { return 10.0 * units + 200; }
    String label() { return "AC"; }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();
            switch (type) {
                case "SINGLE": list.add(new SingleRoom(units)); break;
                case "SHARED": list.add(new SharedRoom(units, sc.nextInt())); break;
                default:       list.add(new ACRoom(units));
            }
        }
        double total = 0;
        for (Room r : list) {
            double b = r.bill();
            total += b;
            System.out.printf("%s: %.2f%n", r.label(), b);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
