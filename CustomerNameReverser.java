import java.util.Scanner;

public class CustomerNameReverser {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            throw new IllegalArgumentException("Customer name cannot be null.");
        }

        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String originalName = scanner.nextLine();

        try {
            String reversedName = reverseCustomerName(originalName);
            System.out.println("Original Name: " + originalName);
            System.out.println("Reversed Name: " + reversedName);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}