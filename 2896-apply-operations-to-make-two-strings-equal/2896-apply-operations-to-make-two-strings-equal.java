/** dp **
* Find all the indices where bit in s1 is not the same as the bit in s2. Then we need to flip bits at these positions.
* - eg. s1 = "1100011000", s2 = "0101001010", x = 2. The use a list idx to store the incides, idx = {0, 3, 5, 8}, 1-indexed
* Use dp[i] to represent the min cost to make all the chars equals before idx[i],it's similar to a house rob problem
* Let's double the cost for each operation. For ith idx, 
* - we either pair ith with nothing, then the cost is 2x / 2 = x, the dp[i] = dp[i - 1] + x;
* - or we pair it with the one before, which is (i -1)th idx, the cost is min, then dp[i] = dp[i - 2] + 2 * min(x, idx[i-1] - idx[i-2])
*/
class Solution {
    public int minOperations(String s1, String s2, int x) {
        //list - store the index where bit in s1 not same as bit in s2
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) idx.add(i);
        }
        
        int n = idx.size();
        if (n % 2 != 0) return -1;
        if (n == 0) return 0;
        
        int[] dp = new int[n + 1]; //dp[i] - min cost to make s1[0..idx(i-1)] equals s2[0..idx(i - 1)]
        dp[0] = 0;
        dp[1] = x;
        for (int i = 2; i <= n; i++) {
            //we doubled the cost for each operations
            int cost1 = dp[i - 1] + x;
            int cost2 = dp[i - 2] + 2 * Math.min(x, idx.get(i - 1) - idx.get(i - 2));
            dp[i] = Math.min(cost1, cost2);
        }
        //divide by 2 since the total cost is doubled
        return dp[n] / 2;
    }
}
//Time: O(n); Space: O(n)
