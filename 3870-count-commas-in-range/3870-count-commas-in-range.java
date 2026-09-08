// class Solution {
//     public int countCommas(int n) {
//         int count =1;
//         if(n < 1000) return 0;
//         for(int i=1000; i<n; i++){
//             count += 1;
//         }
//         return count;
//     }
// }



class Solution {
    public int countCommas(int n){
        if(n < 1000) return 0;
        return (n - 1000)+1;
    }
}