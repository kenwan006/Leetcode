class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }
    
    public void backtrack(int[] candidates, int start, int target) {
        if (trackSum > target) return;
        if (trackSum == target) {
            res.add(new LinkedList(track));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            trackSum += c;
            track.add(c);
            backtrack(candidates, i, target);
            track.removeLast();
            trackSum -= c;
        }
    }
}