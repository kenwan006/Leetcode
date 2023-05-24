public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //check the least significant bit and then shift it out
            count += n & 1; 
            n = n >>> 1;
        }
        return count;
    }
}