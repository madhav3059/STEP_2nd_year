import java.util.Arrays;

public class DiceThrowTally {

    /**
     * Counts occurrences of each dice face (1 to 6) without pairwise comparisons (Counting Sort),
     * prints the frequency tally, and returns a sorted array[cite: 13].
     *
     * @param rolls array of dice rolls containing values from 1 to 6[cite: 13]
     * @return a new array containing the rolls sorted in increasing order[cite: 13]
     */
    public static int[] diceSort(int[] rolls) {
        if (rolls == null) {
            return new int[0];
        }

        // Count array of size 7 to index faces 1 through 6 directly[cite: 13]
        int[] count = new int[7];

        for (int val : rolls) {
            if (val >= 1 && val <= 6) {
                count[val]++;
            }
        }

        // Print counts in the format: Counts: 1:x 2:x 3:x 4:x 5:x 6:x[cite: 13]
        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + (v < 6 ? " " : "\n"));
        }

        // Reconstruct the sorted array using the frequencies[cite: 13]
        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            while (count[v] > 0) {
                sorted[index++] = v;
                count[v]--;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Input ---");
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4}; //[cite: 13]
        int[] sorted1 = diceSort(rolls1);
        System.out.println("Sorted: " + Arrays.toString(sorted1)); //[cite: 13]

        System.out.println("\n--- Custom Test Input ---");
