class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] seen;
    public List<List<Integer>> permute(int[] nums) {
        seen = new boolean[nums.length];
        backtrack(nums);
        return res;
    }
    
    private void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (seen[i]) continue;
            seen[i] = true;
            track.add(nums[i]);
            backtrack(nums);
            track.removeLast();
            seen[i] = false;
        }
    }
}