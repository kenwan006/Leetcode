class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }
    
    private void backtrack(int[] candidates, int start, int target) {
        // base case
        if (trackSum > target) return;
        if (trackSum == target) {
            res.add(new LinkedList(track));
            return;
        }
        
        // backtrack
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i]) // trim; avoid the duplicate numbers at the same layer
                continue;
            trackSum += candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, i + 1, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}