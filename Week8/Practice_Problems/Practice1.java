import java.util.*;

abstract class Payment {
    protected double amount;
    Payment(double amount) { this.amount = amount; }
    abstract double finalAmount();
    abstract String label();
}

class CardPayment extends Payment {
    CardPayment(double a) { super(a); }
    double finalAmount() { return amount * 1.02; }
    String label() { return "CARD"; }
}

class WalletPayment extends Payment {
    WalletPayment(double a) { super(a); }
    double finalAmount() { return amount * 1.01; }
    String label() { return "WALLET"; }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double a) { super(a); }
    double finalAmount() { return amount; }
    String label() { return "BANKTRANSFER"; }
}

public class Practice1 {
    static Payment create(String type, double amount) {
        switch (type) {
            case "CARD":   return new CardPayment(amount);
            case "WALLET": return new WalletPayment(amount);
            default:       return new BankTransferPayment(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amt = sc.nextDouble();
            list.add(create(type, amt));
        }
        double total = 0;
        for (Payment p : list) {
            double f = p.finalAmount();
            total += f;
            System.out.printf("%s: %.2f%n", p.label(), f);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
