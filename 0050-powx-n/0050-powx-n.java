/** Iteratively **/
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x; //i could be negative, so i % 2 could be 0, 1, -1
            x *= x;
        }
        return n < 0? 1 / res : res;
    }
}
//Time: O(log(n)); Space: O(1)

