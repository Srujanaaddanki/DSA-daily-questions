class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int length = Integer.toBinaryString(n).length();
        int ans = ((1 << length) -1);
        return n ^ ans;
    }
}

                 //// line no - 4 /////
// int length = Integer.toBinaryString(5).length();
// It takes the math number 5, calculates its binary form, and generates the text word "101"
// now our code see => int length = "101".length();
// finally It counts the characters in "101", gets the number 3