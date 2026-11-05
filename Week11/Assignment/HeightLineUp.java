import java.util.Arrays;

public class HeightLineUp {

    /**
     * Sorts the heights array using adjacent swaps (Bubble Sort)
     * and prints the array after each pass until fully sorted.
     */
    public static void lineUp(int[] heights) {
        int n = heights.length;
        int pass = 1;

        for (int i = 0; i < n; i++) {
            boolean swapped = false;

            // Sweep from left to right, swapping adjacent elements if out of order
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            // Print the array state after the sweep
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;

            // If no swaps occurred, the line is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Input 1 ---");
        int[] heights1 = {4, 2, 5, 1};
        lineUp(heights1);

        System.out.println("\n--- Sample Input 2 ---");
        int[] heights2 = {1, 3, 2, 4};
        lineUp(heights2);

        System.out
