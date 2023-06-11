class Solution {
    public String smallestString(String s) {
        int n = s.length(), i = 0;
        char[] chars = s.toCharArray();
        
        //skip the leading 'a'
        while (i < n && chars[i] == 'a') i++;
        if (i == n) chars[n - 1] = 'z'; // s has all 'a' letters
        
        //walk over the non 'a' and stop at the next 'a'
        while (i < n && chars[i] != 'a') chars[i++]--;
        
        return new String(chars);
    }
}
//Time: O(n); Space: O(n)

