class Solution {
    public int minMoves(int[] nums) {
       int ans = 0;
       Arrays.sort(nums);
       int n = nums.length;
       int lar = nums[n - 1];
       for(int i=0; i<n; i++){
        ans = ans + (lar - nums[i]);
       }
       return ans;
    }
}