class Trie {
    class Node {
        Node[] children = new Node[26]; //represent 26 lowercase letters
        boolean isWord = false;
        public Node() {};
    }
    
    private Node root = new Node();
    
    public Trie() {
        
    }
    
    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) curr.children[i] = new Node();
            curr = curr.children[i];
        }
        curr.isWord = true; //mark the end of the word
        
    }
    
    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {        
            int i = c - 'a';
            if (curr.children[i] == null) return false;
            curr = curr.children[i];
        }
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {        
            int i = c - 'a';
            if (curr.children[i] == null) return false;
            curr = curr.children[i];
        }
        return  true;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */