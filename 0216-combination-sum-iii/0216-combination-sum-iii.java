class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1);
        return res;
    }
    
    private void backtrack(int k, int n, int start) {
        if (trackSum > n) return;
        if (track.size() > k) return;
        if (track.size() == k && trackSum == n) {
            res.add(new LinkedList(track));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            track.add(i);
            trackSum += i;
            backtrack(k, n, i + 1);
            trackSum -= i;
            track.removeLast();
        }
    }
}