class Solution {
    public int pivotIndex(int[] nums) {
        int Total_Sum = 0;
        int left_Sum = 0;
        // i calculated totalSum
        for(int num : nums){
            Total_Sum += num;
        }
        for(int i = 0; i < nums.length; i++){
            int right_Sum = Total_Sum - left_Sum - nums[i];
            if(left_Sum == right_Sum){
                return i;
            }
            left_Sum += nums[i];
        }
        return -1;
    }
}