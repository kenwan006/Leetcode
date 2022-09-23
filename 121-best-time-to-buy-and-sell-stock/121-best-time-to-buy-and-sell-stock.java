/**
* Iterate over the prices, if find price < current min price, then update it
* And keep track of the profit = current price - min price, update it if greater than the existing max profit
*/
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0; // just in case the price is in the straight decrease
        
        for (int price : prices) {
            if (price < minPrice) 
                minPrice = price;
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}