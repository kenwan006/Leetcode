class Solution {
    public int minimumSwaps(int[] nums) {
        //find the max num at the right most position, and min num at the left most position
        int n = nums.length;
        int l = 0, r = 0;
        int min = nums[0], max = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[l]) l = i;
            if (nums[i] >= nums[r]) r = i; //use >=
        }
        
        //then move l to 0 and move r to n -1
        int res = l + (n - 1 - r);
        
        if (l > r) res--; //edge case
        
        return res;
    }
}

//Time: O(n); Space: O(1)

