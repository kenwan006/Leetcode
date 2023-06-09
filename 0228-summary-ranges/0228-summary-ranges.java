class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) i++;
            
            if (nums[i] != start) res.add(start + "->" + nums[i]);
            if (nums[i] == start) res.add("" + start);
        }
        return res;
    }
}
//Time: O(n); Space: O(1)
