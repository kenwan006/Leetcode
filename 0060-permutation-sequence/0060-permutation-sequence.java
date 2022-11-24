class Solution {
    int count = 0;
    StringBuilder track = new StringBuilder();
    String res;
    boolean[] visited;
    
    public String getPermutation(int n, int k) {
        visited = new boolean[n + 1]; // 0,1,2..n
        backtrack(n, k);
        return res.toString();
    }
    
    private void backtrack(int n, int k) {
        if (track.length() == n) {
            count++;
            if (count == k) {
                res = track.toString();
            }
            return;
        }
   
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            track.append(i);
            backtrack(n, k);
            track.deleteCharAt(track.length() - 1);
            visited[i] = false;
        }
        
    }
}

//Time: O(2^n); Space: O(n)