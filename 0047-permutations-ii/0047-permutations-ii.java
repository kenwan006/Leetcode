class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }
    
    public void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) continue;
            visited[i] = true;
            track.add(nums[i]);
            backtrack(nums);
            track.removeLast();
            visited[i] = false;
        }
    }
}