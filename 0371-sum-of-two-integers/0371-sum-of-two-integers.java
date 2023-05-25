class Solution {
    public int getSum(int a, int b) {
        int x = Math.abs(a), y = Math.abs(b);
        if (x < y) return getSum(b, a);
        
        int sign = a > 0? 1 : -1;
        
        // both positive or both negative, calcualte x + y
        if (a * b >= 0) {
            while (y != 0) {
                int sum = x ^ y;
                int carry = (x & y) << 1;
                x = sum;
                y = carry;
            }
        }
        
        // one positive and one negative, calculate x - y
        if (a * b  < 0) {
            while (y != 0) {
                int diff = x ^ y;
                //only when bit in x is 0 and bit in y is 1 --> bit in borrow is 1
                int borrow = (~x & y) << 1; //borrow from higher bit
                x = diff; 
                y = borrow;
            }
        }
        
        return x * sign;
    }
}