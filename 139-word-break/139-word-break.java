class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] memo = new boolean[s.length() + 1]; // memo[i] - whether string s[0,1...i-1] is wordBreak
        memo[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) { // j - iterate over the string s
                if(memo[j] && set.contains(s.substring(j, i))) { 
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }
}