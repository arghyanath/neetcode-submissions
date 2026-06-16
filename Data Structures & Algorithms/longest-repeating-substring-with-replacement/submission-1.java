class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int maxFreq = 0;
        int i = 0;
        int j = 0;
        int maxWin = 0;

        while (j < s.length()) {

            maxFreq = Math.max(++freq[s.charAt(j) - 'A'] , maxFreq);

            if (j - i + 1 - maxFreq <= k) {
                maxWin = Math.max(maxWin, j - i + 1);
            }
            else {
                while (j - i + 1 - maxFreq  > k) {

	                freq[s.charAt(i) - 'A']--;

                    maxFreq = 0;
                    for (int p = 0; p < 26; p++) {
                        maxFreq = Math.max(freq[p], maxFreq);
                    }
	                i++;
            	}
            }
            j++;
        }

        return maxWin;
    }
}
