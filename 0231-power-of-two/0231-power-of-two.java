public class Solution {
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            int ans = (int) Math.pow(2, i);
            if (ans == n) {
                return true;
            }
        }
        return false;
    }
}
// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         int x;
//         int p = 2^x; 
//         if(x >= 0 && n==p){
//             return true;
//         }
//         return false;
//     }
// }


// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         if (n <= 0) return false;
//         while (n % 2 == 0) {
//             n /= 2;
//         }
//         return n == 1;
//     }
// }