/** Iteration *
* Iterate over the string s from left to right, always make all chars in s[0...i] are equal.
* When checking s[i], if s[i] != s[i - 1], either invert all chars in s[0...i-1] so that they are equal to s[i]
* or invert the s[i..n-1] to ensure that s[i] is equal to the char in s[0...i-1]
* Both operations can get all chars in s[0...i] to be equal, but need to choose the one with less cost.
*/
class Solution {
    public long minimumCost(String s) {
        long cost = 0, n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                cost += Math.min(i, n - i);
            }
            //if current char is same as previous one, then just move to next one
        }
        return cost;
    }
}
//Time: O(n); Space: O(1)



