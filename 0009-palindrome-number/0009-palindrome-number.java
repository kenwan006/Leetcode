class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int n = x, y = 0;
        while (n != 0) {
            y = y * 10 + (n % 10);
            n /= 10;
        }
        return y == x;
    }
}
//Time:O(log(n)); Space: O(1)
