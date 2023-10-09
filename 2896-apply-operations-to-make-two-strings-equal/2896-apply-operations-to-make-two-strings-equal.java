class Solution {
    public int minOperations(String s1, String s2, int x) {
        //list - store the index where bit in s1 not same as bit in s2
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) list.add(i);
        }
        
        int n = list.size();
        if (n % 2 != 0) return -1;
        if (n == 0) return 0;
        
        int[] dp = new int[n + 1]; //dp[i] - min cost to make s1[0..list.get(i)] equals s2[0..list.get(i)]
        dp[0] = 0;
        dp[1] = x;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + x, dp[i - 2] + 2 * Math.min(x, list.get(i - 1) - list.get(i - 2)));
        }
        return dp[n] / 2;
    }
}