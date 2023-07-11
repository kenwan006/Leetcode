class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, i = n - 1;
        int[] res = new int[n];
        while (l <= r) {
            int ls = nums[l] * nums[l];
            int rs = nums[r] * nums[r];
            if (ls < rs) {
                r--;
                res[i] = rs;
            } else {
                l++;
                res[i] = ls;
            }
            i--;
        }
        return res;
    }
}
//Time: O(n); Space: O(n)
