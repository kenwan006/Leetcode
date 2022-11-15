/** Trie + backtracking
* Use a trie (root) to represent a dictionary containing all the words added. 
 - Eg, if we add a word "bad", then at the first layer, children[1] is not null, at the second layer, children[0] is not null, the third layer children[3] is not null and mark isEnd as true. Every time adding a new word, we check each of its letters.
* When searching a word, if it only contains letters, we just keep each letter of the word until the letter is not in the root or the end of word;
If it contains '.', it could reprsent any letter from 'a' to 'z'. Then while walking to this layer of the root,  we can use a for loop to check each option. 
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
    //Define a helper function - backtracking
    //use k to represent the index position of the checked character or depth layer of the trie
    private boolean search (char[] chs, int k, TrieNode cur) {
        if (chs.length == k) return cur.isEnd;
        if (chs[k] == '.') {
            for (int i = 0; i < 26; i++) {
                //only check the branch which is not null
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