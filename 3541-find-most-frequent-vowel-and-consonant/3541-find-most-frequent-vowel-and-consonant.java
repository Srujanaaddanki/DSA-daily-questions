class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        int vowels = 0;
        int consonant = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (isVowel(ch)) {
                vowels = Math.max(vowels, hm.getOrDefault(ch, 0));
            } else {
                consonant = Math.max(consonant, hm.getOrDefault(ch, 0));
            }
        }
        return vowels + consonant;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}


// Phase 1: Building the Map (Counting)
// to build map count 
// mp.put(ch, mp.getOrDefault(ch, 0) + 1);


//Phase 2: Finding the Maximum (Comparing)
//reads from the map
//vowel = Math.max(vowel, mp.getOrDefault(ch, 0));