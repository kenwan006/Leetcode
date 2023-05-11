/** State machine + dp **/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //state[i] - action happens on ith day and state turns into held[i]
        int[] held = new int[n];  
        int[] sold = new int[n]; //max profix if stock sold the end of ith day
        int[] rest = new int[n]; 
        
        //base case 
        held[0] = -prices[0];
        sold[0] = -prices[0];
        rest[0] = 0;
        
        //dp
        for (int i = 1; i < n; i++) {
            held[i] = Math.max(held[i - 1], rest[i - 1] - prices[i]);
            sold[i] = held[i -1] + prices[i]; // hold stock on (i-1)th day and sell on ith day
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }
        return Math.max(rest[n - 1], sold[n - 1]);
    }
}
//Time: O(n); Space: O(n)