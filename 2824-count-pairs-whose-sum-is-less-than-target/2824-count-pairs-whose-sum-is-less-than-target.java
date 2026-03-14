import java.util.*;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);  // 1. Sort the list first!
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;    // List uses .size(), not .length!
        while (left < right) {
            int sum = nums.get(left) + nums.get(right); // List uses .get(), not []!   
            if (sum < target) {
                count += (right - left);
                left++;                // Move left pointer up to try and find more pairs
            } else {
                        // The sum is too big, move the right pointer to a smaller number
                right--; 
            }
        }       
        return count;
    }
}