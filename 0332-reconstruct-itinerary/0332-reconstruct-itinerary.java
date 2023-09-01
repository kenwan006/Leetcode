/** Backtracking **/
class Solution {
    Map<String, List<String>> map;
    LinkedList<String> track;
    int count = 0;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        track = new LinkedList<>();
        count = tickets.size()+ 1; 
        
        //build the map
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            map.putIfAbsent(src, new ArrayList<>());
            // the same [src, dst] could exist multiple times
            //eg, "JFK" : {"ATL", "ATL", "SJC", "SFO"...}
            map.get(src).add(dst); 
        }
        
        //sort destinations for each source in lexical order
        for (String src : map.keySet()) {
            Collections.sort(map.get(src));
        }
        track.add("JFK");
        backTracking("JFK");
        return track;
    }
    
    private boolean backTracking(String src) {
        if (track.size() == count) return true;
        
        if (!map.containsKey(src)) return false;
        
        for (int i = 0; i < map.get(src).size(); i++) {
            String dst = map.get(src).get(i);
            track.add(dst);
            map.get(src).remove(i); //remove this src -> dst from map
            if (backTracking(dst)) return true;
            track.removeLast();
            map.get(src).add(i, dst); //restore the map
        }
        return false;
    }
}