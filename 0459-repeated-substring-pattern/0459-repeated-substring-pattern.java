/** String concatenation *
* If s = "abcabc", let t = s + s = "abcabcabcabc", then remove head and tail of t to get t = "bcabcabcab"
* Check if t contains s, if yes then it means s has repeated pattern.
**/
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        return t.substring(1, t.length() - 1).contains(s);
    }
}