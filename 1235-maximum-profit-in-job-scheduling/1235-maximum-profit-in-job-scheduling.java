/** Bottom-up DP + Binady search
* Sort all the jobs by the start time
* dp[i] - means the maximum profit if we schedule the jobs starting from job i 
* The bottom case when i = n -1 is we only schedule the last job dp[n-1] 
* For the ith job, we either schedule it and schedule the next non-conflicting job, or skip it and schedule starting (i+1)th job
* dp[i] = max {profit[i] + dp[next], dp[i+1]}
*/

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // construct jobs
        int L = startTime.length;
        int[][] jobs = new int[L][3];
        for (int i = 0; i < L; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        // sort the jobs by startTime
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // bottom up DP
        int[] dp = new int[L];
        dp[L -1] = jobs[L - 1][2]; // the base case is when only schedule the last job
        for (int i = L - 2; i >= 0; i--) {
            int next = findNext(jobs, i); // find the next job not conflicting with current one
            dp[i] = Math.max(jobs[i][2] + (next == -1 ? 0 : dp[next]), dp[i + 1]);
        }
        return dp[0];
    }
    
    // binary search
    public int findNext(int[][] jobs, int i) {
        int lo = i + 1, hi = jobs.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (jobs[mid][0] >= jobs[i][1]) {
                if (jobs[mid - 1][0] >= jobs[i][1]) 
                    hi = mid - 1;
                else 
                    return mid;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
