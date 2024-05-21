class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int curr_max = nums[i];
            for (int j = i + 1; j < n * 2; j++) {
                if (nums[j % n] > nums[i]) {
                    curr_max = nums[j % n];
                    break;
                }
            }
            if (curr_max == nums[i]) res[i] = -1;
            else res[i] = curr_max;
        }
        return res;
    }
}