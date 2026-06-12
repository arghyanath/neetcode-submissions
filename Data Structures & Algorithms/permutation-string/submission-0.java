class Solution {
    public boolean checkInclusion(String s1, String s2) {
       Map<Character, Integer> map = new HashMap<>();
		
		int k = s1.length();
		
		for (int c = 0; c < k; c++) {
			
			char ch = s1.charAt(c);
			
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}
		
		int mapCount = map.size();
		int i = 0;
		int j = 0;
		
		while(j < s2.length()) {
			
			char jCh = s2.charAt(j);
			
			if(map.containsKey(jCh)) {

				map.put(jCh, map.get(jCh) - 1);
				
				if(map.get(jCh) == 0)
					mapCount--;
			}
			if(j - i + 1 < k) {
				j++;
			}
			else if (j - i + 1 == k) {
					
				if(mapCount == 0)
					return true;

				char iCh = s2.charAt(i);
				
				if(map.containsKey(iCh))
				{
					if(map.get(iCh) == 0)
						mapCount++;

					map.put(iCh, map.get(iCh) + 1);
				}
				
				i++;
				j++;
				
			}
		}

		return false;
    }
}
