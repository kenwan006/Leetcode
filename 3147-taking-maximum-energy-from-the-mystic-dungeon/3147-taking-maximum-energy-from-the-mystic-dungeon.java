class Solution {
    int res = Integer.MIN_VALUE;
    
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);
        
        for (int i = 0; i < n; i++) {
            if (memo[i] != Integer.MIN_VALUE) continue;
            dfs(i, k, energy, memo);
        }
        return res;
    }
    
    //max energy starting from index i
    private int dfs(int i, int k, int[] energy, int[] memo) {
        if (i >= memo.length) return 0;
        if (memo[i] != Integer.MIN_VALUE) return memo[i];
        
        int sum = 0;
        sum = energy[i] + dfs(i + k, k, energy, memo);
        
        memo[i] = sum;
        res = Math.max(res, memo[i]);
        
        return sum;
    }
}

//top-down dp