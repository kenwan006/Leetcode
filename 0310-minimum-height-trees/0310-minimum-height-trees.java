/** Topological Sorting
(Origianl idea: for each vertex, set it as the root and calculate the corresponding height. Then find  those with min height. This would fail due to time limit exception).
- Basics: a tree graph can't have more than 2 minimum height trees(MHTs)
- keep trimming the leaves unital there are 1 or 2 vertics left
*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList<Integer> leaves = new LinkedList<>();
        if (n == 0) return leaves;
        if (n == 1) {
            leaves.add(0);
            return leaves;
        } // n = 2 (or 1 edge) will be considered when initializing the leaves
    
        //Build graph
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashSet<Integer>());
        for (int[] edge : edges) {
            int i = edge[0], j = edge[1];
            adj.get(i).add(j);
            adj.get(j).add(i);
        }
        
        //Initial leaves- only with one neighbor
        for (int i = 0; i < n; i++){
            if (adj.get(i).size() == 1)
                leaves.add(i);
        }
        
        //Trim the leaves
        while (n > 2) {
            int size = leaves.size();
            for (int k = 0; k < size; k++) {
                int i = leaves.remove(); // node i only has one neighbor j
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i); // remove i from j's neighbors
                if (adj.get(j).size() == 1) leaves.add(j);
                n--;
            }
        }
        return leaves;
    }
}