class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int m = nums.length/2;
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
            if(hm.get(nums[i]) >m){
                return nums[i];
            }
        }
      return 0;  
    }
}






















// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer, Integer> counts = new HashMap<>();
//         int majorityCount = nums.length / 2;
//         for (int n : nums) {
//             int currentCount = counts.getOrDefault(n, 0) + 1;
//             counts.put(n, currentCount);
//             if (currentCount > majorityCount) {
//                 return n;
//             }
//         }  
//         return -1;
//     }
// }





// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int n : nums){
//             map.put(n, map.getOrDefault(n,0)+1);
//         }
//         for(int key : map.keySet()){
//             if(map.get(key) > nums.length/2){
//                 return key;
//             }
//         }
//         return -1;
//     }
// }





























