class Solution {
    int maxLen;
    public int maxLength(List<String> arr) {
        maxLen = 0;
        dfs(0, "", arr);
        return maxLen;
    }
    
    private void dfs(int start, String concat, List<String> arr) {
        maxLen = Math.max(maxLen, concat.length());
        if (start == arr.size()) {
            return;
        }
        
        for (int i = start; i < arr.size(); i++) {
            String curr = arr.get(i);
            if (contains(concat, curr)) continue;
            dfs(i + 1, concat + curr, arr);
        }
    }
    
    //check if s1 contains any char in s2, also check if s2 has duplicate chars
    private boolean contains(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (char c : s1.toCharArray()) set.add(c);
        
        Set<Character> set2 = new HashSet<>();
        for (char c : s2.toCharArray()) {
            if (set.contains(c) || set2.contains(c)) return true;
            set2.add(c);
        }
        return false;
    }
}