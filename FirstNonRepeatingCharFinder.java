import java.util.Scanner;

public class FirstNonRepeatingCharFinder {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Input text must not be null or empty.");
        }

        // ASCII frequency array
        int[] frequencyMap = new int[256];

        // Pass 1: Tally frequencies
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                frequencyMap[ch]++;
            }
        }

        // Pass 2: Identify first character with frequency == 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && frequencyMap[ch] == 1) {
                return ch;
            }
        }

        // Sentinel character indicating no unique character exists
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string to search: ");
        String input = scanner.nextLine();

        try {
            char result = findFirstNonRepeatingChar(input);
            if (result != '\0') {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("No Non-Repeating Character Found");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}