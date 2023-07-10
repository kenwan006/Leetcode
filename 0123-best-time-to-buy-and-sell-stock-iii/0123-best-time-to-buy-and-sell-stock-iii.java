class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] leftProfit = new int[n]; //leftProfit[i] - refers to the max profit for prices[0..i] within one transaction
        /** pad addtional 0 to the right for convenience **/
        int[] rightProfit = new int[n + 1];//rightProfit[i] - refers to the max profit for preices[i..n] within one transaction
        
        //check from left to right - update buy price if needed
        leftProfit[0] = 0;
        int buy = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < buy) buy = prices[i]; 
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - buy);
        }
        
        //check from right to left - update sell price if needed
        rightProfit[n - 1] = 0;
        int sell = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > sell) sell = prices[i]; //update the sell price
            rightProfit[i] = Math.max(rightProfit[i + 1], sell - prices[i]);
        }
        
        //find the max profit within two transactions
        int res = 0;
        for (int i = 0; i < n; i++) res = Math.max(res, leftProfit[i] + rightProfit[i + 1]);
        return res;
    }
}
//Time: O(n); Space: O(n)
