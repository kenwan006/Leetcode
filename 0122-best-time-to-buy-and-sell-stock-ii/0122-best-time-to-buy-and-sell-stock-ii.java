/** Greey 
** Peaks and valleys 
*/
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, peak = prices[0], valley = prices[0];
        int i = 0, n = prices.length;
        while (i < n - 1) {
            //find valley
            while (i < n - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];
            
            //find peak
            while (i < n - 1 && prices[i] <= prices[i + 1]) i++;
            peak = prices[i];
            
            profit += peak - valley;
        }
        return profit;
    }
}
//Time: O(n); Space: O(1)

