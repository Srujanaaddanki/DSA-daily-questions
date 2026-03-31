class Solution {
    public String generateString(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int sz = n + m - 1;

        char[] word = new char[sz];
        Arrays.fill(word, '$');

        // Step 1: Apply 'T' constraints
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '$') {
                        word[i + j] = s2.charAt(j);
                    } else if (word[i + j] != s2.charAt(j)) {
                        return "";
                    }
                }
            }
        }

        // Step 2: Copy original state
        char[] word2 = word.clone();

        // Step 3: Process 'F' constraints
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'F') {

                int cntBlank = 0, cntSame = 0;
                int lastBlank = -1;

                for (int j = 0; j < m; j++) {

                    if (word2[i + j] == '$') {
                        if (word[i + j] == '$') {
                            word[i + j] = 'a';
                        }
                        lastBlank = i + j;
                        cntBlank++;
                    }

                    if (word[i + j] == s2.charAt(j)) {
                        cntSame++;
                    }
                }

                if (cntSame == m && cntBlank == 0) return "";

                if (cntSame == m && cntBlank > 0) {
                    word[lastBlank] = 'b';
                }
            }
        }

        return new String(word);
    }
}