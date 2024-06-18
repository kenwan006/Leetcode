class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>(); //map managerID -> his employees ID
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(headID);
        
        int[] times = new int[n]; //time when ith employee get informed
        
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currID = queue.poll();
                int managerID = manager[currID];
                if (currID != headID) times[currID] = times[managerID] + informTime[managerID];
                
                if (map.containsKey(currID)) queue.addAll(map.get(currID));
                
                res = Math.max(res, times[currID]);
            }
        }
        return res;
    }
}