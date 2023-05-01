/** dijkstra + heap 
* In this solution, all points [x, y] are represented as a list, Arrays,asList(x, y) for the better use of map.contaisKey(key)
**/
class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        //distance from start to current position list(x, y)
        Map<List<Integer>, Integer> dist = new HashMap<>();
        dist.put(Arrays.asList(start[0], start[1]), 0);
        
        //add the point to the heap according to their distance to start
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        heap.offer(new int[] {start[0], start[1], 0}); 
        
        //map a point to its adjcent point with distance, list(x, y) ->[xx, yy, distance]
        Map<List<Integer>, List<int[]>> roads = new HashMap<>(); 
        roads.put(Arrays.asList(target[0], target[1]), new ArrayList<>()); //important!!
        for (int[] road : specialRoads) {
            List<Integer> s = Arrays.asList(road[0], road[1]);
            int xt = road[2], yt = road[3], d = road[4];
            roads.putIfAbsent(s, new ArrayList<>());
            roads.get(s).add(new int[]{xt, yt, d});
        }
        
        //dijkstra
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int x = curr[0], y = curr[1], d = curr[2];
            List<Integer> p = Arrays.asList(x, y);
            if (x == target[0] && y == target[1]) return d;
            
            //update the neighbors of current point [x, y] in special roads
            for (int[] adj : roads.getOrDefault(p, new ArrayList<>())) {
                int xx = adj[0], yy = adj[1], dd = adj[2];
                List<Integer> pp = Arrays.asList(xx, yy);
                if (d + dd < dist.getOrDefault(pp, Integer.MAX_VALUE)) {
                    dist.put(pp, d + dd);
                    heap.offer(new int[]{xx, yy, d + dd});
                }
            
            }
            
            //update all the points in the special roads, not necessarily the neighobor of [x, y]
            for (List<Integer> pi: roads.keySet()) {
                int xx = pi.get(0), yy = pi.get(1);
                int dd = Math.abs(xx - x) + Math.abs(yy -y);
                if (dd + d < dist.getOrDefault(pi, Integer.MAX_VALUE)) {
                    dist.put(pi, d + dd);
                    heap.offer(new int[]{xx, yy, d + dd});
                }
            }
        }
        return -1;
    }
}
                 
                 
                 
