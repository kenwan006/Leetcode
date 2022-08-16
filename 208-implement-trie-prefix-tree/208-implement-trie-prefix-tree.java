class Trie {
    class Node { // nested class
        boolean isEnd;
        Node[] children = new Node[26];
        Node() {}; 
    }
    
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c- 'a'] == null) curr.children[c - 'a'] = new Node();
            curr = curr.children[c - 'a']; // move node to the next layer if current char exists
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c- 'a'] == null) return false;
            curr = curr.children[c - 'a']; 
        }
        return curr.isEnd; // the word could be a prefix of some existing word
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children[c- 'a'] == null) return false;
            curr = curr.children[c - 'a']; 
        }
        return true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */