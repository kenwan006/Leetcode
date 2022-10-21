/**
* Iterate over the prices, if we find price < current min price, then update it
* And keep track of the profit = current price - min price, update it if greater than the existing max profit
*/

class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int price : prices) {
            min_price = Math.min(min_price, price);
            max_profit = Math.max(max_profit, price - min_price);
        }
        return max_profit;
    }
}