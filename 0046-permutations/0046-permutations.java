class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;
    
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }
    
    public void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            used[i] = false;
            track.removeLast();
        }
    }
    
}