class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }
    
    private void backtrack(int[] candidates, int target, int start) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new LinkedList(track));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            sum += num;
            track.add(num);
            backtrack(candidates, target, i);
            track.removeLast();
            sum -= num;
        }
    }
}