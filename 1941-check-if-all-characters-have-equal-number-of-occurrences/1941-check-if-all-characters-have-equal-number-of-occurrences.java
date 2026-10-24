class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int count = hm.get(s.charAt(0));
        for(int value : hm.values()){
            if(count != value){
                return false;
            }
        }
        return true;
    }
}




// The 3 Core Navigation Methods of HashMapWhenever 
// you need to inspect what is inside a HashMap, Java gives you three methods:MethodWhat It ReturnsExample 
// 1) hm.values()   -> A collection of only values  ->  Checking if all frequencies match
// 2) hm.keySet()   -> A set of only keys  ->  Finding all unique characters present
// 3) hm.entrySet() ->Both key & value pairs  ->  Printing or inspecting both together