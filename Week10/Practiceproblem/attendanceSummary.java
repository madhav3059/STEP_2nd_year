public class Main {

    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int current = 0;
        int longest = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                current++;
                longest = Math.max(longest, current);
            } else {
                current = 0;
            }
        }

        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        int[] days = {1, 1, 0, 1, 1, 1, 0, 1};

        int[] result = attendanceSummary(days);

        System.out.println("Present: " + result[0]
                + ", Longest streak: " + result[1]);
    }
}
