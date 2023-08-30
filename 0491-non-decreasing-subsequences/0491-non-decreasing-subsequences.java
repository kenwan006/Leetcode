class Solution {
    Set<List<Integer>> res = new HashSet<>();
    LinkedList<Integer> track = new LinkedList<>();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return new LinkedList(res);
    }
    
    private void backTracking(int[] nums, int start) {
        if (track.size() >= 2) res.add(new LinkedList(track));
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; //trimming for the same level
            if (start > 0 && nums[i] < nums[start - 1]) continue; // curr level is i, previous level is start - 1
            
            track.add(nums[i]);
            backTracking(nums, i + 1);
            track.removeLast();
        }
    }
}