class Solution {
    public int maxProfit(int[] prices) {
        /**
        Here are three states, held, sold, rest
        held - either last state is already held, or last state is rest and buy a stock now
        sold - last state must be held
        rest - either last state is already rest, or last state is sold
        **/
        
        int n = prices.length;
        int[] held = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];
        
        //base case
        held[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;
        
        for (int i = 1; i < n; i++) {
            held[i] = Math.max(held[i - 1], rest[i - 1] - prices[i]);
            sold[i] = held[i - 1] + prices[i];
            rest[i] = Math.max(rest[i -1], sold[i - 1]);
        }
        
        return Math.max(sold[n - 1], rest[n - 1]);
    }
}