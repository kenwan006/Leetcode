/** Counting factors of 5 - optimized **/
class Solution {
    public int trailingZeroes(int n) {
        int res = 0, ctn = 0;
        while (n > 0) {
            ctn = n / 5;
            n /= 5;
            res += ctn;
        }
        return res;
    }
}
//Time: O(log(n)); Space: O(1)
