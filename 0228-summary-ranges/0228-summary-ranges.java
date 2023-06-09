class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length, i = 0; //[i..j] nums are consecutive in this interval
        if (n == 0) return res;
        
        for (int j = 0; j < n - 1; j++) {
            if (nums[j] + 1 != nums[j + 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if (i != j) sb.append("->").append(nums[j]);
                res.add(sb.toString());
                i = j + 1; //update the start of the new interval
            }
        }
        //check the last interval
        StringBuilder sb = new StringBuilder();
        sb.append(nums[i]);
        if (i != n - 1) sb.append("->").append(nums[n - 1]);
        res.add(sb.toString());
        
        return res;
    }
}
//Time: O(n); Space: O(n)
