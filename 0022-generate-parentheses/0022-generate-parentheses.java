/** Backtracking **/
class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder track;
    
    public List<String> generateParenthesis(int n) {
        track = new StringBuilder();
        backtrack(track, 0, 0, n);
        return res;
    }
    
    private void backtrack(StringBuilder track, int left, int right, int n) {
        //Base case
        if (left == n && right == n) {
            res.add(track.toString());
            return;
        }
        
        //backtracking
        if (left < n) {
            track.append("(");
            backtrack(track, left + 1, right, n);
            track.deleteCharAt(track.length() - 1);
        }
        
        if (left > right) {
            track.append(")");
            backtrack(track, left, right + 1, n);
            track.deleteCharAt(track.length() - 1);
        }
    }
}