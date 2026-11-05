import java.util.Arrays;

public class LibraryBookShelf {

    /**
     * Sorts the books array in increasing order using Insertion Sort
     * and prints the shelf state after each book (from the second book onwards) is placed.
     *
     * @param books array of book numbers
     */
    public static void shelf(int[] books) {
        if (books == null || books.length <= 1) {
            return;
        }

        // Start from the second book (index 1)
        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;

            // Shift elements of books[0..i-1] that are greater than key to one position ahead
            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }

            // Insert the current book into its correct position
            books[j + 1] = key;

            // Print the array after placing the current book
            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Input ---");
        int[] books = {30, 10, 40, 20};
        shelf(books);

        System.out.println("\n--- Custom Test Input ---");
        int[] customBooks = {55, 12, 89, 42, 5};
        shelf(customBooks);
    }
}
