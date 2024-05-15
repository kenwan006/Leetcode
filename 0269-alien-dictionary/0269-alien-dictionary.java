class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indeg = new HashMap<>(); // in indegree of a node
        
        //build the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indeg.putIfAbsent(c, 0);
            }
        }
        int n = words.length;
        for (int i = 1; i < n; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            
            //if word2 is a prefix of word1
            if (!word1.equals(word2) && word1.startsWith(word2)) return "";
                
            //compare two words - char by char until no match
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j), c2 = word2.charAt(j);
                if (c1 != c2) { //check if edge c1->c2 already exist
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2); //add the edge c1->c2 to the graph
                        indeg.put(c2, indeg.get(c2) + 1); //increment the indeg of node c1 by 1
                    }
                    break;
                }
            }
        }
        
        //toppological sorting
        Queue<Character> queue = new LinkedList<>();
        for (char c : indeg.keySet()) {
            if (indeg.get(c) == 0) queue.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character src = queue.poll();
            sb.append(src);
            for (Character next : graph.get(src)) {
                //update the indeg of the next node and add the node with 0 indeg to the queue
                if (indeg.get(next) == 1) queue.offer(next);
                indeg.put(next, indeg.get(next) - 1);
            }
        }
        
        //check if all letters have been included
        if (sb.length() != graph.size()) return "";
        return sb.toString();
    }
}