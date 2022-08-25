class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        backtrack(candidates, 0, target, 0);
        return res;
    }
    
    public void backtrack(int[] candidates, int start, int target, int sum) {
        // base case
        if (sum == target) {
            res.add(new LinkedList(track)); // Ref type; create a new linkedlist
            return;
        }
        if (sum > target) return;

        // backtracking
        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, i, target, trackSum); // new start is still i not i+1
            track.removeLast();
            trackSum -= candidates[i];
        }    
    }
    
}