class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, board, res, root);
            }
        }
        return res;
    }
    
    
    //Dfs traverse
    private void dfs(int i, int j, char[][]board, List<String>res, TrieNode node) {
        //base case
        char c = board[i][j];
        if (board[i][j] == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a']; //move to next layer of trie
        
        //check if any target reached
        if (node.word != null) {
            res.add(node.word);
            node.word = null; //add the word to res and remove it from the trie to avoid duplicates
        }
       
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        //dfs search the neighbors
        board[i][j] = '#'; //mark as visited
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if( ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length)
                dfs(ii, jj, board, res, node);
        }
        board[i][j] = c; //mark it back as unvisited
    }
    
    //Construct the trie including all given words
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (node.children[i] == null) node.children[i] = new TrieNode();
                node = node.children[i]; //check the next letter of the word
            }
            node.word = word; // at the end of the trie node, include the word
        }
        return root;
    }
    //TrieNode class
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; //only when it comes to the leaf, we add this word
        TrieNode() {};
    }
}