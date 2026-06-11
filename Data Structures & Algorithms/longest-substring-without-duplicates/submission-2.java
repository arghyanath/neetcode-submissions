class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
		
		Map<Character, Integer> map = new HashMap<>();
		
		int i = 0;
		int j = 0;
		int maxLength = 0;
		
		while(j < n)
		{
			if(map.containsKey(s.charAt(j)))
			{
				i = map.get(s.charAt(j)) + 1;
				j = i;
				map.clear();
			}
			else 
			{
				maxLength = Math.max(j - i + 1, maxLength);
			}
            
			map.put(s.charAt(j), j);
			
			j++;
		}
		
		return maxLength;
    }
}
