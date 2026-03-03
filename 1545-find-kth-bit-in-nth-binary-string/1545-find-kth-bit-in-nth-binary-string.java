class Solution {
    public char findKthBit(int n, int k) {
        String s ="0";
        for(int i=2;i<=n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<s.length();j++){
                char c = s.charAt(j);
                sb.append(c=='0'?'1':'0');
            }
            sb.reverse();
            s=s+"1"+sb.toString();
        }
        return s.charAt(k-1);
    }
}