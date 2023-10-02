class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int m = name.length(), n = typed.length();
        while (i < m && j < n) {
            if (name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
                continue;
            } else {
                if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) j++;
                else return false;
            }
        }
        
        while (j < n && typed.charAt(j) == typed.charAt(j - 1)) j++;
        
        return i == m && j == n;
    }
}
//Time: O(n); Space: O(1)

