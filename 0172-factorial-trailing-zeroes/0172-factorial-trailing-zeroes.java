/** Counting factors of 5 **/
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <= n; i+= 5) {
            int num = i, ctn = 0;
            while (num % 5 == 0) {
                ctn++;
                num /= 5;
            }
            res += ctn;
        }
        return res;
    }
}
//Time: O(n); Space: O(1)
