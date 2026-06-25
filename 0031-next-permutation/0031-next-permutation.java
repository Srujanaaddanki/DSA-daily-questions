class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // Step 1: Find the first decreasing element from the back
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // If i breaks out and is >= 0, it means the array isn't entirely descending
        if (i >= 0) {
            // Step 2: Find the next largest element to swap with nums[i]
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // Step 3: Reverse the remaining elements to the right of index i
        // (If i fell to -1, this reverses the whole array to reset it!)
        reverse(nums, i + 1, n - 1);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}