public class QueueOrderCheck {

    /**
     * Checks if the queue is sorted in non-decreasing order[cite: 12].
     *
     * @param tokens array of token numbers[cite: 12]
     * @return the 0-based index of the first element smaller than the one before it,
     *         or -1 if the queue is completely in order[cite: 12].
     */
    public static int firstBreak(int[] tokens) {
        // An empty queue or single-student queue is always in order[cite: 12]
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        // Compare each element with the one immediately before it[cite: 12]
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Sample Input 1[cite: 12]
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        System.out.println(firstBreak(tokens1)); // Expected Output: 4[cite: 12]

        // Sample Input 2[cite: 12]
        int[] tokens2 = {1, 2, 2, 7};
        System.out.println(firstBreak(tokens2)); // Expected Output: -1[cite: 12]

        // Custom Test Input (unsorted near the beginning)
        int[] tokens3 = {10, 4, 12, 15};
        System.out.println(firstBreak(tokens3)); // Expected Output: 1

        // Custom Test Input (empty array)[cite: 12]
        int[] tokens4 = {};
        System.out.println(firstBreak(tokens4)); // Expected Output: -1
    }
}
