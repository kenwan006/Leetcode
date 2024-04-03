class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (2 * k + 1 > n) return res;
        
        //sum up the sliding window
        long sum = 0; //don't use int
        int K = k * 2 + 1;
        for (int i = 0; i <= 2 * k; i++) sum += nums[i];
        res[k] = (int) (sum / K);
        for (int j = 2 * k + 1; j < n; j++) {
            sum += (nums[j] - nums[j - 2*k - 1]);
            res[j - k] = (int) (sum / K);
        }
        return res;
    } 
}