class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int num1 = 0, num2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = num2;
            num2 += num1;
            num1 = temp;
        }
        return num2;
    }
}
//Time: O(n); Space: O(1)
