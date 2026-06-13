class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] res = new int[n - k + 1];
		TreeSet<Integer> set = new TreeSet<>();

		TreeMap<Integer, Integer> map = new TreeMap<>();

		int i = 0;
		int j = 0;
        int idx = 0;

		while (j < nums.length) {

			if (map.containsKey(nums[j])) {
				map.put(nums[j], map.get(nums[j]) + 1);
			}
			else {
				map.put(nums[j], 1);
			}
			

			if(j - i + 1 < k) {
				j++;
			}
			else if(j - i + 1 == k) {
				res[idx++] = map.lastKey();

				if (map.containsKey(nums[i])) {
					map.put(nums[i], map.get(nums[i]) - 1);
		
					if(map.get(nums[i]) == 0)
						map.remove(nums[i]);
				}

				i++;
				j++;
			}
		}
        

		return res;
    }
}
