class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

		int n = nums.length;
        
		Deque<Integer> q = new LinkedList<>();
		int[] res = new int[n - k + 1];
		
		int i = 0;
		int j = 0;
		int idx = 0;

		while (j < n) {

			if(q.isEmpty())
			{
				q.offer(nums[j]);
			}
			else if (q.peekLast() >= nums[j]) {
				q.offerLast(nums[j]);
			}
			else {
				while(!q.isEmpty() && q.peekLast() < nums[j])
					q.pollLast();

				q.offerLast(nums[j]);
			}


			if(j - i + 1 < k) {
				j++;
			}
			else if(j - i + 1 == k) {

				res[idx++] = q.peekFirst();

				if (nums[i] == q.peekFirst())
					q.pollFirst();

				i++;
				j++;
			}
		}

		return res;
    }
}
