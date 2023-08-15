/** Backtracking **/
class Solution {
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        backtrack(cookies, new int[k], k, 0);
        return res;
    }
    
    //backtrack
    private void backtrack(int[] cookies, int[] children, int k, int curr) {
        if (curr == cookies.length) {
            int max = 0;
            for (int c : children) max = Math.max(max, c);
            res = Math.min(res, max);
            return;
        }
        
        for (int i = 0; i < k; i++) {
            children[i] += cookies[curr]; // give current cookie to ith child
            backtrack(cookies, children, k, curr + 1);
            children[i] -= cookies[curr];
        }
    }
}
//Time: O(k ^ n); Space: O(k + n)

