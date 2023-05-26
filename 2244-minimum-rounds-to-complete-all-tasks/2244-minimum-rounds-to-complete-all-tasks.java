class Solution {
    public int minimumRounds(int[] tasks) {
        //map task to its frequence
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxCount= Math.max(maxCount, map.get(task));
        }
        if (maxCount < 2) return -1;
        
        //dp[i] - check if task of freq i can be completed
        int[] dp = new int[maxCount + 1];
        Arrays.fill(dp, tasks.length);
        dp[0] = 0;
        dp[2] = 1;
        for (int i = 3; i <= maxCount; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 3]) + 1;
        }
        
        //check all the freq for the tasks
        int res = 0;
        for (int count : map.values()) {
            if (dp[count] == tasks.length) return -1;
            res += dp[count];
        }
        return res;
    }
}
//Time: O(n); Space: O(n)
