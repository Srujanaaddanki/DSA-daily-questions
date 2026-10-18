class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = 0;
        int n = nums.length;
         int i = 0;
         int j = 0;
        double sum = 0;
        double maxSum = 0;
        while (j<k){
            sum = sum + nums[j];
            j++;
        }
        maxSum = sum + maxSum;
        while(j<n){
            sum = sum + nums[j] - nums[i];
            maxSum = Math.max(maxSum,sum);
            i++;
            j++;
        }
        return ans = maxSum/k;
    }
}