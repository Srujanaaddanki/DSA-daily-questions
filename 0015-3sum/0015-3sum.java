import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array so we can use Two Pointers and skip duplicates
        Arrays.sort(nums);

        // Step 2: Loop through the array, locking in our first number (nums[i])
        // We stop at length - 2 because we need at least two more numbers for a triplet
        for (int i = 0; i < nums.length - 2; i++) {
            
            // Micro-optimization: If the smallest number is > 0, we can never reach a sum of 0
            if (nums[i] > 0) break;
            
            // Duplicate Trap 1: Never use the same starting number twice
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; 
            }

            // Step 3: Set up Two Pointers for the remaining array
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // We found a valid triplet! Add it to the results.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Duplicate Trap 2: Skip identical 'left' numbers
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Duplicate Trap 3: Skip identical 'right' numbers
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inward to look for new combinations
                    left++;
                    right--;
                    
                } else if (sum < 0) {
                    // The sum is too small. We need a bigger number, so move left pointer up.
                    left++;
                } else {
                    // The sum is too big. We need a smaller number, so move right pointer down.
                    right--;
                }
            }
        }

        return result;
    }
}