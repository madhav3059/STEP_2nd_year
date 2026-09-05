import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;

        k = k % n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        // Copy values back into original nums array
        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);
        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
