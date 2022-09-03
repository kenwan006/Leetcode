class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return null;
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }
    
    public void backtrack(int[] nums, int start) {
        res.add(new LinkedList(track));     
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();   
        }
    }
}