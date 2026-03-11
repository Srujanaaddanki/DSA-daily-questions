class Solution {
    public int findComplement(int num) {
        if(num == 0) return 1;
        int length = Integer.toBinaryString(num).length();
        int ans = ((1 << length)-1);
        return num ^ ans;
    }
}