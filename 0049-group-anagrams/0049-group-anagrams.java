class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) 
            return new ArrayList<>();
            
        Map<String, List<String>> hm = new HashMap<>();
        
        for(String string : strs){
            char[] ch = string.toCharArray();
            Arrays.sort(ch);
            
            // FIX: Build the new string using the sorted characters (ch)!
            String sortedString = new String(ch);
            
            if(!hm.containsKey(sortedString)){
                hm.put(sortedString, new ArrayList<>());
            }
            hm.get(sortedString).add(string);
        }
        
        return new ArrayList<>(hm.values());
    }
}