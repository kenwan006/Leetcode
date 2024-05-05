class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //combine three arrays into one list of nodes
        List<Node> list = new ArrayList<>();
        int n = username.length;
        for (int i = 0; i < n; i++) {
            list.add(new Node(username[i], timestamp[i], website[i]));
        }
        
        //sort the nodes by timestamp
        Collections.sort(list, (a, b) -> a.timestamp - b.timestamp);
        
        //map username -> all its websites visited
        Map<String, List<String>> map = new HashMap<>();
        for (Node node : list) {
            String u = node.username;
            String w = node.website;
            map.putIfAbsent(u, new ArrayList<>());
            map.get(u).add(w);
        }
        
        //for each user, find all possible patterns, and map pattern -> its occurences
        Map<String, Integer> patterns = new HashMap<>();
        for (List<String> weblist : map.values()) {
            int m = weblist.size();
            if (m < 3) continue;
            
            //choose three web from the website in ascending order of time
            Set<String> set = new HashSet<>(); // a weblist may have repeated pattern, we only need one
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    for (int k = j + 1; k < m; k++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(weblist.get(i)).append(" ").append(weblist.get(j)).append(" ").append(weblist.get(k));
                        set.add(sb.toString());
                    }
                }
            }
            
            for (String s : set) patterns.put(s, patterns.getOrDefault(s, 0) + 1);
        }
        
        //find the pattern with max occurences
        int max = 0;
        String target = "";
        for (String s : patterns.keySet()) {
            if (max < patterns.get(s)) {
                max = patterns.get(s);
                target = s;
            } else if (max == patterns.get(s)) { //get the smaller pattern lexicographically
                if (target.compareTo(s) > 0) target = s;
            }
        }
        
        //convert the target string to list of string by spliting 
        String[] res = target.split(" ");
        return List.of(res);
    }
    
    class Node {
        String username;
        int timestamp;
        String website;
        public Node (String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }
}