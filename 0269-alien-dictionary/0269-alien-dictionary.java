/* Topological sorting 
* Build a graph - each vertex represents a char; If we can ensure char i appears before char j lexicographically, then there is an edge i ->j
* For two words w1 and w2 (w1 before w2 in the array), compare each char in w1 and w2 until w1[i] != w2[i], it means w1[i] is in front of w2[i] lexicographically, then we can form an edge w1[i] -> w2[i].
* For each word in the words, do the comparison as above.
* Find the vertex with 0 indeg and remove them. Update the indeg for all the remaining vertices and reapeated this step unitl there is no vertex.
*/
class Solution {
    public String alienOrder(String[] words) {
        //build the graph
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indeg = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indeg.put(c, 0); //include all existing chars with initial 0 indeg
                graph.put(c, new ArrayList<>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            //check if w2 is a prefix of w1
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            //find the index that w1[j] != w2[j]
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indeg.putIfAbsent(c2, 0);
                        indeg.put(c2, indeg.get(c2) + 1); //update the indeg for the inclined vertex
                    }
                    break; //once an edge c1 ->c2 found, stop comparison
                }
            }
        }
        
        //use a queue to include all vertices with 0 indegree
        Queue<Character> queue = new LinkedList<>();
        for (char c : indeg.keySet()) {
            if (indeg.get(c) == 0) queue.offer(c);
        }
        
        //topological sorting
        String s = "";
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char v = queue.poll();
                s += v;
                for (char adj : graph.get(v)) {
                    indeg.put(adj, indeg.get(adj) - 1); //update the indeg for the adjacent vertices
                    if (indeg.get(adj) == 0) queue.offer(adj);
                }
            }
        }
        
        //only s contains all chars is a vliad answer
        if (s.length() != indeg.size()) return "";
        return s;
        
    }
}
//Time: O(m * n) m - avg length of eahc word, n - number of word 
//Space: O(v + e)