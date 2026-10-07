// MovieTicketCounter.java
import java.util.Locale;
import java.util.Scanner;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;
    protected final int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double pricePerTicket();

    final double totalPrice() {
        return count * (pricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) { super(count); }
    double pricePerTicket() { return 150.0; }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) { super(count); }
    double pricePerTicket() { return 250.0; }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) { super(count); }
    double pricePerTicket() { return 400.0; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] seats = new String[n];
        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            seats[i] = sc.next();
            int count = sc.nextInt();

            switch (seats[i]) {
                case "REGULAR": tickets[i] = new RegularTicket(count); break;
                case "PREMIUM": tickets[i] = new PremiumTicket(count); break;
                case "RECLINER": tickets[i] = new ReclinerTicket(count); break;
                default: throw new IllegalArgumentException("Unknown seat: " + seats[i]);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double amount = tickets[i].totalPrice();
            System.out.printf("%s: %.2f%n", seats[i], amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
