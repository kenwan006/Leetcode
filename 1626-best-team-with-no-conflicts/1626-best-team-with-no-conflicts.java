/** Dp **/
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] ageToScore = new int[n][2]; // pair(age, score)
        for (int i = 0; i < n; i++) ageToScore[i] = new int[]{ages[i], scores[i]};
        Arrays.sort(ageToScore, (a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        
        int[] dp = new int[n]; //dp[i] - refers to the overall score of a team with oldest age - ith age
        
        for (int i = 0; i < n; i++) dp[i] = ageToScore[i][1]; //init
            
        int maxSum = dp[0];
        for (int i = 1; i < n; i++) { 
            for (int j = i - 1; j >= 0; j--) {
                //current player i is either same age as privous player j
                //or check the younger privous age that has lower or equal score
                if (ageToScore[i][0] == ageToScore[j][0] || ageToScore[i][1] >= ageToScore[j][1]) dp[i] = Math.max(dp[i], dp[j] + ageToScore[i][1]);
                maxSum = Math.max(maxSum, dp[i]);
            }
        }
        return maxSum;
    }
}
//Time: O(n * n); Space: O(n)