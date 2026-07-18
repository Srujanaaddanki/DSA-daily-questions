class Solution {
    public int findGCD(int[] nums) {
        // 1. Sort the array to instantly find the minimum and maximum
        Arrays.sort(nums);
        int small = nums[0];
        int large = nums[nums.length - 1];
        
        // 2. Count down from 'small' to find the GREATEST common divisor
        for (int i = small; i >= 1; i--) {
            // Check if 'i' divides both numbers perfectly
            if (small % i == 0 && large % i == 0) {
                return i; // The first one we find going backward is the greatest!
            }
        }
        
        return 1;
    }
}