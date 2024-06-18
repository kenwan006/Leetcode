class Solution {
    int res = 0;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>(); //map managerID -> his employees ID
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        
        dfs(map, informTime, headID, 0);
        
        return res;
    }
    
    private void dfs(Map<Integer, List<Integer>> map, int[] informTime, int currID, int currTime) {
        res = Math.max(res, currTime);
        if (!map.containsKey(currID)) return;
        
        for (int adj : map.get(currID)) {
            dfs(map, informTime, adj, currTime + informTime[currID]);
        }
    }
}