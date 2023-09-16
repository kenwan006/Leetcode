class Solution {
    public int numTrees(int n) {
        // dp[i] - means the number of unique bst given i nodes
        // focus on the number of total nodes not the value of each node
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) { //i - total number of nodes in the bst
            for (int j = 0; j < i; j++) { // j - nodes in the left child; i - 1 - j nodes in the right
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
//Time: O(n * n); Space: O(n)
