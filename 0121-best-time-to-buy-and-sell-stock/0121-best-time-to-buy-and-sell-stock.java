class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPricePrior = Integer.MAX_VALUE;
        for (int i=0; i< prices.length; i++) {
            minPricePrior = Math.min(minPricePrior, prices[i]);
            profit = Math.max(profit, prices[i] - minPricePrior);
        }
        return profit;
    }
}