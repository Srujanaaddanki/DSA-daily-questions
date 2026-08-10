class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] nArr = new int[26];
        for(int i=0; i<s.length(); i++){
            nArr[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<t.length(); i++){
            nArr[t.charAt(i) - 'a']--;
        }
        for(int i=0; i<nArr.length; i++){
            if(nArr[i] !=0){
                return false;
            }
        }
        return true;
    }
}



















// //  Valid Anagram if they contain the exact same characters with the exact same frequencies, just rearranged in a different order

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length()) return false;
//         int[] c = new int[26];
//         for(int i = 0; i<s.length(); i++){
//             c[s.charAt(i) - 'a']++;
//         }
//         for(int i = 0; i<t.length(); i++){
//             c[t.charAt(i) - 'a']--;
//         }
//         for(int i = 0; i<c.length; i++){
//             if(c[i] != 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }