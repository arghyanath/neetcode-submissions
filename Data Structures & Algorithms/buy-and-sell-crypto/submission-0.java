class Solution {
    public int maxProfit(int[] prices) {
        int minEle = prices[0];
        int profit = 0;

        for(int i = 0; i < prices.length; i++ )
        {
            minEle = Math.min(prices[i], minEle);
            profit = Math.max(prices[i] - minEle, profit);
        }
        return profit;
    }
}
