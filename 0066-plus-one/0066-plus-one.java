class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length, carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9 && carry == 1) {
                digits[i] = 0;
                //carry = 1;
            } else {
                digits[i] += carry;
                carry = 0;
            }
        }
        if (carry == 1) {
            digits = new int[n + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
//Time: O(log(n)); Space: extra O(1)
