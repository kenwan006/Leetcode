class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        //build trie
        Trie root = new Trie();
        for (String p : products) {
            Trie curr = root;
            for (char c : p.toCharArray()) {
                if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Trie();
                curr = curr.children[c - 'a'];
                if (curr.list.size() < 3) curr.list.add(p); //at each node we store at most 3 product words
            }
        }
        
        //search each prefix of searchWord on the trie
        List<List<String>> res = new ArrayList<>();
        Trie curr = root;
        for (char c : searchWord.toCharArray()) {
            if (curr == null) {
                res.add(new ArrayList<>());
            } else {
                curr = curr.children[c - 'a'];
                if (curr != null) res.add(curr.list);
                else res.add(new ArrayList<>());
            }
        }
        
        return res;
    }
    
    class Trie {
        List<String> list = new ArrayList<>();
        Trie[] children = new Trie[26];
        public Trie(){}
    }
}

//Time: O(m), m is the total chars in the products; Space: O(n) - n is the number of products