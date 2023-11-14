class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
        public TrieNode(){};
    }
    
    public int findMaximumXOR(int[] nums) {
        // build the Trie
        // most significant (leftmost) bit on the top of the Trie
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode curr = root;
            for (int i = 30; i >= 0; i--) { //move 30 bits to the right, to get the most left bit
                int currBit = (num >>> i) & 1;
                if (curr.children[currBit] == null) curr.children[currBit] = new TrieNode();
                curr = curr.children[currBit];
            }
        }
        
        //for each num, starting from the most left bit
        //and at the same layer, check if its negation bit exist in the Trie 
        int max = 0;
        for (int num : nums) {
            TrieNode curr = root;
            int sum = 0;
            for (int i = 30; i >= 0; i--) {
                int x =(num >>> i) & 1; //current bit in num
                int y = x ^ 1; //negation of current bit
                if (curr.children[y] != null) {
                    curr = curr.children[y];
                    sum += (1 << i);
                } else {
                    curr = curr.children[x];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}