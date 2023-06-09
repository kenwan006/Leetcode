class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length, i = 0; //[i..j] nums are consecutive in this interval
        if (n == 0) return res;
        
        for (int j = 0; j < n - 1; j++) {
            if (nums[j] + 1 != nums[j + 1]) {
                if (i != j) res.add(nums[i] + "->" + nums[j]);
                if (i == j) res.add("" + nums[i]);
                i = j + 1; //update the start of the new interval
            }
        }
        //check the last interval
        if (i == n - 1) res.add("" + nums[n - 1]);
        if (i != n - 1) res.add(nums[i] + "->" + nums[n - 1]);
        return res;
    }
}
//Time: O(n); Space: O(n)
