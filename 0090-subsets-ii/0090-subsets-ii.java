class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }
    
    private void backtrack(int[]nums, int start) {
        res.add(new LinkedList(track));
        
        for (int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i - 1]) // trim; avoid using the duplicate at the same layer
                continue;
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}