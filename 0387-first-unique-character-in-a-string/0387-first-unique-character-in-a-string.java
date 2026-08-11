class Solution {
    public int firstUniqChar(String s) {
       HashMap<Character,Integer> hm = new HashMap<>(); 
       int count = 1;
       for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
       }
       for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
            if(hm.get(ch) == count){
                return i;
            }
       }
       return -1;
    }
}



















// class Solution {
//     public int firstUniqChar(String s) {
//         int [] c = new int[26];
//         for(int i = 0; i<s.length(); i++){
//             c[s.charAt(i) - 'a']++;
//         }
//         for(int i = 0; i<s.length(); i++){
//             if(c[s.charAt(i) - 'a'] == 1){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }















// class Solution {
//     public int firstUniqChar(String s) {
//         HashMap<Character, Integer> hm = new HashMap<>();
//         char[] ch = s.toCharArray();
//         for(int i=0; i<ch.length; i++){
//             // Just put it! Don't check if it exists first.
//             hm.put(ch[i], hm.getOrDefault(ch[i], 0) + 1);
//         }
//         // 2. Loop AGAIN to find the answer
//         for(int i=0; i<ch.length; i++){
//             // Check if this specific character has a count of 1
//             if(hm.get(ch[i]) == 1){
//                 return i; // Valid here because i exists in this loop
//             }
//         }  
//         return -1; // Return -1 if no unique char is found
//     }
// }