class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        if (x < 0) return -reverse(-x);
        
        int MAX = Integer.MAX_VALUE;
        
        int num = 0;
        while (x > 0) {
            int carry = x % 10;
            if ((num > MAX / 10 && carry > 0) || (num == MAX / 10 && carry > MAX % 10)) return 0;
            
            num = num * 10 + carry;
            
            x /= 10;
        }
        return num;
    }
}