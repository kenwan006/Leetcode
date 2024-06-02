class Solution {
    List<List<Integer>> res;
    List<Integer> track;
    int product;
    public List<List<Integer>> getFactors(int n) {
        res = new LinkedList<>();
        track = new LinkedList<>();
        product = n;
        
        backtrack(2, n);
        return res;
    }
    
    private void backtrack(int start, int n) {
        if (product == 1) {
            if (track.size() > 1) res.add(new LinkedList(track));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (product % i != 0) continue;
            track.add(i);
            product /= i;
            backtrack(i, n / i);
            product *= i;
            track.removeLast();
        }
    }
}