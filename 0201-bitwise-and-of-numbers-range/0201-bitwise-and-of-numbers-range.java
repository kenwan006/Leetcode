/** Find the common prefix of n and m 
* shift both n and m to the right until m == n
eg: m = 0001xxx, n = 0001xxx, after shifting 3 times m = n = 00000001, then shift to the left 3 time to get the resut 0001000
**/
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left = left >>> 1;
            right = right >>> 1;
            shift++;
        }
        return left << shift;
    }
}
//Time: O(1); Space: O(1)