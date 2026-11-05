import java.util.Arrays;

public class RemoveDuplicatesSorted {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);

        System.out.println("length = " + length); // length = 5
        System.out.print("nums[0.." + (length - 1) + "] = [");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + (i < length - 1 ? ", " : "]\n"));
        }
    }
}
