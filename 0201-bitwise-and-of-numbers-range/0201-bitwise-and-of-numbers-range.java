/** use n & (n - 1) to turn off n's rightmost bit of 1
* eg, n = 000011 1000, n - 1 = 000011 0111, n = n & (n - 1) = 000011 0000, we can see the rightmost 1 in n has been removed
* Question is why do we skip all number between 000011 1000 and 000011 0000 ? because they would always reduce to 000011 0000
* eg the number 000011 0100, the bitwise AND of this number and 000011 0000 is still 000011 0000
**/
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }
}
//Time: O(1); Space: O(1)
