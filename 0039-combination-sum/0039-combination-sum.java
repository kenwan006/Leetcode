class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }
    
    private void backtrack(int[] nums, int target, int start) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        
        if (sum > target) return;
        
        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            track.add(nums[i]);
            backtrack(nums, target, i);
            track.removeLast();
            sum -= nums[i];
        }
    }
    
}