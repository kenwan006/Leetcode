class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        //insert all num in the arr1 to Trie
        TrieNode root = new TrieNode();
        for (int num : arr1) {
            String s = num + "";
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - '0';
                if (curr.children[idx] == null) curr.children[idx] = new TrieNode();
                curr = curr.children[idx];
            }
            curr.isEnd = true;
        }
        
        //for each num in arr2, search it in the already built Trie
        int res = 0;
        for (int num : arr2) {
            String s = num + "";
            TrieNode curr = root;
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - '0';
                if (curr.children[idx] != null) {
                    curr = curr.children[idx];
                    len++;
                } else {
                    break; //stop the current search
                }
            }
            res = Math.max(res, len);
        }
        return res;
    }
    
    class TrieNode{
        TrieNode[] children = new TrieNode[10];
        boolean isEnd;
        public TrieNode(){};
    }
}