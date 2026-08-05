class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0, 1); 
        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            if (hm.containsKey(prefixSum - k)) {
                count += hm.get(prefixSum - k);
            }
            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}