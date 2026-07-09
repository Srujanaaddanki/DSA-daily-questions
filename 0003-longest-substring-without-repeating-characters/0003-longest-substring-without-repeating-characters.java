class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int maxLength = 0;
        int left =0;
        for(int right=0; right<s.length(); right++){
            while(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
            }

            hs.add(s.charAt(right));
            maxLength = Math.max(maxLength,right-left +1);
        }
        return maxLength;
    }
}



//The Difference in Core Logic   
//if statement: Looks at the condition exactly once. If a duplicate exists, it shrinks the left side by exactly one step and moves on.
//while loop: Keeps running repeatedly until the condition becomes completely false. It shrinks the left side step-by-step until the duplicate character is completely kicked out of the window.

//we are using 0-based indexing.
//If you use just right - left
//your formula (right - left):   --> 0 - 0 = 0 
//The math says you have 0 characters. But your eyes clearly see 1 character ("a") in the window! Your count is wrong.

//Using the correct formula (right - left + 1):
//0 - 0 + 1 = 1
//The math correctly matches reality.
