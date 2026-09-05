import java.util.Scanner;

public class FindMinRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If middle is greater than rightmost, minimum lies in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum lies at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(findMin(nums));
        sc.close();
    }
}
