class Solution {
    public int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}

// We are NOT creating a new array.
// 👉 We are modifying the same input array.
// 👉 This is called in-place modification.

// Time: O(n)
// Space: O(1) (since no extra array)
// This is optimal.

// When would we create a new array?
// If the question says: --> “Do not modify the input array”, then we must 👉
// int[] result = new int[nums.length];
// result[0] = nums[0];
// for(int i = 1; i < nums.length; i++){
//     result[i] = result[i-1] + nums[i];
// }
// That would use O(n) extra space

















