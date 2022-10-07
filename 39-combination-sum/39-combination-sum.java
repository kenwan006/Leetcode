class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> track = new LinkedList<>();
    private int sum = 0;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target);
        return res;
    }
    
    private void backtrack(int[] candidates, int start, int target) {
        //base case
        if (sum > target) return;
        if (sum == target) {
            res.add(new LinkedList(track));
            return;
        }
        
        //backtracking
        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            track.add(c);
            sum += c;
            backtrack(candidates, i, target);
            sum -= c;
            track.removeLast();
        }
    }
}