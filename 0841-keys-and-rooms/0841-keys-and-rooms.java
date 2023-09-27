class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        return dfs(0, rooms, new boolean[n]) == n; //start from 0 as it's the only unlocked room
    }
    
    //count how many rooms will be visited starting from room u
    private int dfs(int u, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[u]) return 0;
        visited[u] = true;
        int count = 1;
        for (int v : rooms.get(u)) {
            count += dfs(v, rooms, visited);
        }
        return count;
    }
}