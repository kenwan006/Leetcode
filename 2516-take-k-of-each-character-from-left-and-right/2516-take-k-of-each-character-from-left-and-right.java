class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for (char c : s.toCharArray()) count[c - 'a']++;
        if (count[0] < k || count[1] < k || count[2] < k) return -1;
        
        //the max freq for each char in sliding window [i..j]
        count[0] -= k;
        count[1] -= k;
        count[2] -= k;
        
        int i = 0, n = s.length();
        int max = 0;
        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            count[c - 'a']--;
            
            while (count[c - 'a'] < 0) {
                char cl = s.charAt(i++);
                count[cl - 'a']++;
            }
            
            max = Math.max(max, j - i + 1);
        }
        
        return n - max;
    }
}