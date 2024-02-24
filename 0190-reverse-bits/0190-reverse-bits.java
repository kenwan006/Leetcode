public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;  //bit at least significant position of n
            n >>>= 1;
            res = res * 2 + bit;
        }
        return res;
    }
}