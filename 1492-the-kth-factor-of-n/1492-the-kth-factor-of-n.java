class Solution {
    public int kthFactor(int n, int k) {
        int[] factors = new int[n + 1];
        factors[1] = 1;
        factors[n] = 1; // 1 and n are always factors of n
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                factors[i] = 1;
                factors[n / i] = 1;
            }
        }
        
        //find the kth factor
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (factors[i] == 1) count++;
            if (count == k) return i;
        }
        return -1;
    }
}

//Time: O(n ^ 1/2); Space: O(n)
