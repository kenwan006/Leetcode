/** Trie + backtracking
*
*
*/

class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        Boolean isEnd = false;
        TrieNode() {};
    }
    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) cur.children[ch - 'a'] = new TrieNode();
            cur = cur.children[ch - 'a']; //move to the next character
        }
        cur.isEnd = true; //mark the end of the added word
    }
    
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }
    
    private boolean search (char[] chs, int k, TrieNode cur) {
        if (chs.length == k) return cur.isEnd;
        if (chs[k] == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null && search(chs, k + 1, cur.children[i]))
                    return true;
            }
        } else {
            return cur.children[chs[k] - 'a'] != null && search(chs, k + 1, cur.children[chs[k] -'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */