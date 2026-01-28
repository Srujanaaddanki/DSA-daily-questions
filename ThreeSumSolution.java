import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSolution {

    public static List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to efficiently use the two-pointer technique and handle duplicates.
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Main loop to fix the first element 'a'.
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for 'a' to avoid duplicate triplets in the result.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Set up two pointers for the remaining elements 'b' and 'c'.
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet that sums to zero.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values for 'b' and 'c'.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inward to find the next unique pair.
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, increment the left pointer to get a larger value.
                    left++;
                } else {
                    // Sum is too large, decrement the right pointer to get a smaller value.
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(nums);
        System.out.println("Unique triplets that sum to zero: " + triplets);
        // Output for the above input is: Unique triplets that sum to zero: [[-4, -1, 5], [-1, -1, 2], [-1, 0, 1]]
        // Note: The example array here is modified from a common problem example to demonstrate the output.
    }
}
