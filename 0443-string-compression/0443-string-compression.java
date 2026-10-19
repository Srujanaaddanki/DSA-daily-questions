class Solution {
    public int compress(char[] chars) {
        int k = 0;
        int i = 0;
        while(i < chars.length){
            int j = i;
            while(j <chars.length && chars[j] == chars[i]){
               j++; 
            }
            chars[k++] = chars[i];
            int len = 0;
            len = j - i;
            if(len > 1){
                String s = String.valueOf(len);
                for(char c : s.toCharArray()){
                    chars[k++] = c;
                }
            }
            i = j;
        }
        return k;
    }
}