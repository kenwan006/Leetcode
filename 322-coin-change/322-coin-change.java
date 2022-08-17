class Solution {
    int[] memo; //store memo[i] = dp(coins, i)
    
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -100); // initialize with any value smaller than -1;
        return dp(coins, amount);
    }
    
    public int dp(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount] != -100) return memo[amount];//check if this amount has been visited
        
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if(subProblem == -1) continue; // if no solution to the subproblem then continue check another coin
            res = Math.min(res, subProblem + 1);
        }
        
        res = (res == Integer.MAX_VALUE) ? -1 : res;
        memo[amount] = res;
        return res;
    }
}