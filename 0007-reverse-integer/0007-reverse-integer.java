class Solution {
    public int reverse(int x) {
        int res = 0, mod = 0;
        while (x != 0) {
            mod = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && mod > Integer.MAX_VALUE % 10)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && mod < Integer.MIN_VALUE % 10)) return 0;
            res = res * 10 + mod;
        }
        return res;
    }
}
//Time: O(log(n)); Space: O(1)