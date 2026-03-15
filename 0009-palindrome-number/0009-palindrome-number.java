// class Solution {
//     public boolean isPalindrome(int x) { 
//         if (x < 0) {                     //All negative numbers are automatically FALSE
//             return false;
//         }      
//         String s = String.valueOf(x);   // 2. Convert the integer 'x' into a String 's'    
//         int left = 0;
//         int right = s.length() - 1;
//         while(left < right){
//             if(s.charAt(left) != s.charAt(right)){
//                 return false;
//             }
//             left++;
//             right--;
//         }       
//         return true;
//     }
// }








// This below code is without converting the integer to a string

class Solution {
    public boolean isPalindrome(int x) {
        int digit;
        int rev=0;
        int original = x;
        while(x>0){
            digit=x%10;
            rev = (rev*10) + digit;
            x=x/10;
        }
        if (rev == original){
            return true;
        }else{
            return false;
        }
    }
}
