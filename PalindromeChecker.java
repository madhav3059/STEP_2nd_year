import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative two-pointer check
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive check
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) return true;

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Array reversal check
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to verify palindrome: ");
        String input = scanner.nextLine().trim();

        // Standardize by converting to lowercase for checking
        String normalizedInput = input.toLowerCase();

        boolean iterativeResult = isPalindromeIterative(normalizedInput);
        boolean recursiveResult = isPalindromeRecursive(normalizedInput);
        boolean arrayResult = isPalindromeArrayReversal(normalizedInput);

        System.out.println("\nInput: \"" + input + "\"");
        System.out.println("Iterative: " + (iterativeResult ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (recursiveResult ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (arrayResult ? "Palindrome" : "Not Palindrome"));

        if (iterativeResult == recursiveResult && recursiveResult == arrayResult) {
            System.out.println("Status: All three approaches agree.");
        } else {
            System.out.println("Status: Inconsistency detected across approaches.");
        }

        scanner.close();
    }
}