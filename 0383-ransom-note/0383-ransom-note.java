class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] nArr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            nArr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            nArr[index]--;
            if (nArr[index] < 0) {
                return false;
            }
        }
        return true;
    }
}