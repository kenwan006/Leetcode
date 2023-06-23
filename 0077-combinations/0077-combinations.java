class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }
    
    private void backtrack(int n, int k, int start) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        
        if (start > n) return;
        
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1);
            track.removeLast();
        }
    }
}