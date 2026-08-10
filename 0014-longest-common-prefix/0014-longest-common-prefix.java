class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return " ";
        String first = strs[0]; // here will get first string from the array
        for(int i=0; i<first.length(); i++){
            char ch = first.charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }
}













// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs.length == 0) return "";
//         String first = strs[0];
//         for (int i = 0; i < first.length(); i++) {
//             char ch = first.charAt(i);
//             for (int j = 1; j < strs.length; j++) {
//                 // string too short OR mismatch
//                 if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
//                     return first.substring(0, i);
//                 }
//             }
//         }
//         return first; // entire first string is common
//     }
// }
