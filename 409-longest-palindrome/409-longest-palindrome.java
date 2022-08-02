class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        int ans = 0;
        int odd = 0;
        for (char ch : s.toCharArray()) arr[ch - 'A']++;
        for(int count : arr) {
            if(count % 2 == 1) {
                count = count / 2 * 2;
                odd = 1; // check if any letter appears in odd frequency
            }
            ans += count;
        }
        return odd == 0? ans : ans + 1;        
    }
}