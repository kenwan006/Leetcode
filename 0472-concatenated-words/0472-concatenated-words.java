class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordDict = new HashSet<>(List.of(words));
        List<String> res = new ArrayList<>();
  
        for (String word : words) {
            int n = word.length();
            boolean[] dp = new boolean[n + 1]; //dp[i] - word[0..i) can be created by concatenation of words
            dp[0] = true;
            
            for (int i = 1; i <= n; i++) {
                int j = 0;
                if (i == n) j = 1; //we don't want to check word[0, n) which is itself
                for (; j < i; j++) { //check if word[j..i) contained in the wordDict
                    dp[i] = dp[j] && wordDict.contains(word.substring(j, i));
                    if (dp[i]) break; //stop check j once we confirm the word[0..j) can be cancatenated
                }
            }
            
            if (dp[n]) res.add(word);
        }
        return res;
    }
}

//Time: O(m * n^3); Space: O(m * n), m - number of words, n - max length of a word