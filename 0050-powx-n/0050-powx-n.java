/** Recursively **/
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        
        if (n == Integer.MIN_VALUE) { //-MIN = MAX + 1, which will be overflowed
            n /= 2;
            x *= x;
        }
        
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        
        return n % 2 == 0? myPow(x * x, n / 2) : myPow(x * x, n / 2) * x;
    }
}
//Time: O(log(n)); Space: O(log(n))