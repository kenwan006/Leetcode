class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    //number of subarrys which contain at most k odd number
    private int atMost(int[] nums, int k) {
        int i = 0;
        int res = 0;
        int odds = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 1) odds++;
            while (odds > k) {
                if (nums[i++] % 2 == 1) odds--;
            }
            //we maintain a sliding window [i..j]. within it, each subarray ending with nums[j] have at most k odd numbers
            //count of such subarray ending with nums[j] is j - i + 1;
            res += (j - i + 1);
        }
        return res;
    }  
}