import java.util.Arrays;

public class PrizeTable {

    /**
     * Sorts the marks array in descending order using Selection Sort
     * and counts only the swaps that were actually made.
     *
     * @param marks the array of marks to be sorted
     * @return the total number of swaps performed
     */
    public static int prizeTable(int[] marks) {
        int n = marks.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            // Find the index of the highest mark among remaining elements
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap only if the largest mark is not already at position i
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] marks1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(marks1);
        System.out.println(Arrays.toString(marks1));
        System.out.println("swaps = " + swaps1);

        System.out.println();

        // Sample Input 2
        int[] marks2 = {80, 70, 60};
        int swaps2 = prizeTable(marks2);
        System.out.println(Arrays.toString(marks2));
        System.out.println("swaps = " + swaps2);

        System.out.println();

        // Custom Test Input
        int[] marks3 = {25, 100, 50, 95, 30};
        int swaps3 = prizeTable(marks3);
        System.out.println(Arrays.toString(marks3));
        System.out.println("swaps = " + swaps3);
    }
}
