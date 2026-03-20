class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        
        // Your perfect loop!
        for(int i = 0; i < n; i++) {
            boolean isGood = true; // Let's assume the number is good until proven bad
            
            // 1. Check the number 'k' steps behind (if it exists)
            if (i - k >= 0) {
                if (nums[i] <= nums[i - k]) {
                    isGood = false; // It wasn't strictly greater, so it's not good!
                }
            }
            
            // 2. Check the number 'k' steps ahead (if it exists)
            if (i + k < n) {
                if (nums[i] <= nums[i + k]) {
                    isGood = false; // It wasn't strictly greater, so it's not good!
                }
            }
            
            // 3. If it survived both checks, add it to the sum!
            if (isGood) {
                sum += nums[i]; // Just add the value straight to your sum variable
            }
        }
        
        // Return your final answer!
        return sum;
    }
}


// class Solution {
//     public int sumOfGoodNumbers(int[] nums, int k) {
//         int n = nums.length;
//         int sum = 0 ;
//         int[] ar = new int[n];
//         for(int i =0;i<n;i++){
//             if((ar[i] - k) && (ar[i] + k) > k){
//                 return;
//             }
//         }
//         for(int i=0;i<ar.length;i++){
//             sum += sum;
//         }
//         return sum;
//     }
// }