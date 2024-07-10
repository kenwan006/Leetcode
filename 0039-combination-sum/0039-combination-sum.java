class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> track;
    int trackSum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        track = new LinkedList<>();
        backtrack(candidates, 0, target);
        return res;
    }
    
    private void backtrack(int[] candidates, int start, int target) {
        if (trackSum == target) {
            res.add(new LinkedList(track));
            return;
        } 
        if (trackSum > target) return;
        
        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            trackSum += c;
            track.add(c);
            backtrack(candidates, i, target);
            trackSum -= c;
            track.removeLast();
        }
    }
}