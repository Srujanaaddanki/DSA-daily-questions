// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer,Integer> hm = new HashMap<>();
//         int[] count;
//         for(int i=0;i<nums.length;i++){
//             if(hm.containsKey(nums[i])){
//                 hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
//             }
//         }
//         if(hm.get(nums[i]) > 2){
//             count++;
//         }
//         return count;
//     }
// }


import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // --- Hashmap1 = {} ... Hashmap[x] += 1 ---
        // Step 1: Count the frequencies
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        
        // --- Hashmap2 = {}, maxValue = 0 ---
        // Step 2: Group by frequency and find the highest vote count
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        int maxValue = 0;
        
        // --- for pair in Hashmap1: ---
        for (Map.Entry<Integer, Integer> pair : map1.entrySet()) {
            int num = pair.getKey();      // pair.key
            int freq = pair.getValue();   // pair.value
            
            // Hashmap2[pair.value].append[pair.key]
            if (!map2.containsKey(freq)) {
                map2.put(freq, new ArrayList<>());
            }
            map2.get(freq).add(num);
            
            // if pair.value > maxValue: maxValue = pair.value
            if (freq > maxValue) {
                maxValue = freq;
            }
        }
        
        // --- while(maxValue > 0) ... result.append(...) ---
        // Step 3: Walk backward from the highest frequency to grab the winners
        int[] result = new int[k];
        int resultIndex = 0;
        
        while (maxValue > 0) {
            // Check if any numbers actually got this specific amount of votes
            if (map2.containsKey(maxValue)) {
                // Grab the list of winners at this frequency level
                List<Integer> winners = map2.get(maxValue);
                
                // Add them to our result array until we hit 'k' items
                for (int winner : winners) {
                    result[resultIndex] = winner;
                    resultIndex++;
                    
                    if (resultIndex == k) {
                        return result; // We found our top K, we are done!
                    }
                }
            }
            // maxValue -= 1
            maxValue--; 
        }
        
        return result;
    }
}