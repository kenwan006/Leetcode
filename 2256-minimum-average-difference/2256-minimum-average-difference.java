class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) sum += num;
        
        int minIdx = -1;
        int min = Integer.MAX_VALUE;
        long prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            int x = (int) Math.floor(prefix / (i + 1));
            int y = i == n - 1? 0 : (int) Math.floor((sum - prefix) / (n - i - 1));
            int diff = Math.abs(x - y);
            
            if (diff < min) {
                min = diff;
                minIdx = i;
            }
        }
        return minIdx;
    }
}