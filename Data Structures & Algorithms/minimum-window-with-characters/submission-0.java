class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < t.length(); i++) {

			char ch = t.charAt(i);

			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			}
			else {
				map.put(ch, 1);
			}
		}

		int i = 0;
		int j = 0;
		int charCount = map.size();
		int minWin = Integer.MAX_VALUE;
        String res = "";

		while (j < s.length()) {

			char cj = s.charAt(j);

			if(map.containsKey(cj)) {

				map.put(cj, map.get(cj) - 1);

				if (map.get(cj) == 0)
					charCount--;
			}

			if(charCount > 0) {
				j++;
			}
			else if(charCount == 0) {

				while (charCount == 0) {

					if(minWin > j - i + 1) {
                        minWin = j - i + 1;
                        res = s.substring(i,j+1);
                    }

					char ci = s.charAt(i);

					if (map.containsKey(ci)) {
						map.put(ci, map.get(ci) + 1);

						if (map.get(ci) > 0)
							charCount++;
					}

					i++;
				}

				j++;
			}
		}

		return res;
    }
}
