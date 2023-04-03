/** Sliding window 
* use a sliding window for the haystack, start: start index of the window, start + i: end index of the window
* Compare the letters in haystack and needle, if haystack.charAt(start+i) == needle.charAt(i), then move i to the next;
* If they are not equal, then reset i = 0, and move start of the window to the next, start++;
*/
class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length(), n = haystack.length();
        for (int start = 0; start <= n - m; start++) {
            for (int i = 0; i < m; i++) {
                //break the inner loop once letter not matched
                if (haystack.charAt(start + i) != needle.charAt(i)) break;
                //if matched, then keep moving until it comes to the end of the needle
                if (i == m - 1) return start;     
            }
        }
        return -1;
    }
}
//Time: O(n); Space:O(1)