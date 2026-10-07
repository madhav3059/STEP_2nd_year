import java.util.Locale;
import java.util.Scanner;

abstract class LibraryItem {
    private final String title;
    private final int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    String getTitle() {
        return title;
    }

    int getDaysLate() {
        return daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return getDaysLate() * 2.0;
    }
}

class Dvd extends LibraryItem {
    Dvd(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return Math.min(getDaysLate() * 5.0, 50.0);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return getDaysLate();
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            switch (type) {
                case "BOOK":
                    items[i] = new Book(title, daysLate);
                    break;
                case "DVD":
                    items[i] = new Dvd(title, daysLate);
                    break;
                case "MAGAZINE":
                    items[i] = new Magazine(title, daysLate);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item type: " + type);
            }
        }

        double total = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
    }
}
