class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind(size);
        
        // Use a hashmap - map each mail to a parent index
        Map<String, Integer> mailToIndex = new HashMap<>();
        for (int i = 0; i < size; i++) {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++) { // skip j = 0, the user name
                if(!mailToIndex.containsKey(account.get(j))) {
                    mailToIndex.put(account.get(j), i); 
                }
                int preIndex = mailToIndex.get(account.get(j));
                uf.union(preIndex, i); // unify accounts i and accounts preIndex
            }
        }
        
        // Use a hasmap - map each parent index to a list of emails belonging to the same group
        Map<Integer, Set<String>> disjointSet = new HashMap<>(); 
        for(int i = 0; i < size; i++) {
            int p = uf.find(i); //parent of index i;
            if(!disjointSet.containsKey(p)) disjointSet.put(p, new HashSet<>());
            Set<String> curSet = disjointSet.get(p);
            for(int j = 1; j < accounts.get(i).size(); j++) {
                curSet.add(accounts.get(i).get(j));
            }
            disjointSet.put(p, curSet);
        }
        
        // sort the list of emails & add the user name to the front
        List<List<String>> result = new ArrayList<>();
        for (int i : disjointSet.keySet()) {
            List<String> curList = new ArrayList<>();
            curList.addAll(disjointSet.get(i));
            Collections.sort(curList);
            curList.add(0, accounts.get(i).get(0)); 
            result.add(curList);
        }
        
        return result;       
    }
}

// Union Find Class
class UnionFind {
    int size;
    int[] parent;
    public UnionFind(int size) {
        this.size = size;
        this.parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i; // initialize 
    }
    
    public void union(int p, int q) {
        parent[find(p)] = parent[find(q)];
    }
    
    public int find(int p) { // find the parent of element p
        while(parent[p]!= p) {
            p = parent[p];
        }
        return p;
    }
}