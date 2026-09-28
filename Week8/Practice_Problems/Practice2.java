import java.io.*;
import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;
    LibraryItem(String title) { this.title = title; }
    abstract int loanDays();
    LocalDate dueDate(LocalDate today) { return today.plusDays(loanDays()); }
    String getTitle() { return title; }
}

class Book extends LibraryItem {
    Book(String t) { super(t); }
    int loanDays() { return 14; }
}

class Dvd extends LibraryItem {
    Dvd(String t) { super(t); }
    int loanDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String t) { super(t); }
    int loanDays() { return 3; }
}

public class Practice2 {
    static LibraryItem create(String type, String title) {
        switch (type) {
            case "BOOK": return new Book(title);
            case "DVD":  return new Dvd(title);
            default:     return new Magazine(title);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        LocalDate today = LocalDate.of(2023, 10, 26);
        List<LibraryItem> list = new ArrayList<>();
        while (list.size() < n) {
            String line = br.readLine();
            if (line == null) break;
            line = line.trim();
            if (line.isEmpty()) continue;
            int sp = line.indexOf(' ');
            String type = line.substring(0, sp).toUpperCase();
            String title = line.substring(sp + 1).trim();
            if (title.length() >= 2 && title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }
            list.add(create(type, title));
        }
        for (LibraryItem item : list) {
            System.out.println(item.getTitle() + ": " + item.dueDate(today));
        }
    }
}
