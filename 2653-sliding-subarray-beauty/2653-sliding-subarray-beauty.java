/** Sliding window **/
class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] counter = new int[50]; //count the negative num and save it to counter[num + 50];
        for (int j = 0; j < n; j++) {
            if (nums[j] < 0) counter[nums[j] + 50]++;
            
            int i = j - k + 1; // sliding window [i, j]
            if (i - 1 >= 0 && nums[i - 1] < 0) counter[nums[i- 1] + 50]--; //move nums[i-1] out of the window
            int count = 0;
            if (i >= 0) {
                for (int m = 0; m < 50; m++) {
                    count+= counter[m];
                    if (count >= x) { //use >= not == because one num could appear multiple times
                        res[i] = m - 50;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
//Time: O(n * 50); Space: O(max(n, 50))                                                    