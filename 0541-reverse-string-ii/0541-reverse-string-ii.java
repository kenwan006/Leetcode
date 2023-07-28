class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if (n <= k) {
            swap(chars, 0, n - 1);
            return new String(chars);
        }
        
        int i = 0, j = k - 1;
        while (i < n) {
            swap(chars, i, j);
            i += 2 * k;
            j = Math.min(i + k - 1, n - 1); //right bound can't exceed n - 1
        }
        return new String(chars);
    }
    
    private void swap(char[] chars, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
//Time: O(n); Space: O(n)

