class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0;
        int currXor = 0;
        for (int i = 30; i >= 0; i--) {
            /**
            move the num to right by 30 bits, and get the leftmost bit
            move the num to right by 29 bits, and get two leftmost bits
            ...
            **/
            maxXor <<= 1; //move the maxXor to left by 1bit, and check if 1 can be added to the rightmost bit
            currXor = maxXor | 1; //set the rightmost to 1. Difference bwtween maxXor and currXor is the rightmost bit
            
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) prefixes.add(num >> i);
            
            //find the pair (x, y) in the set that x ^ y = currXor  <=> x = currXor ^ y
            //if we can find it, then update maxXor = currXor, otherwise no change to maxXor
            for (int x : prefixes) {
                if (prefixes.contains(currXor ^ x)) {
                    maxXor = currXor;
                    break;
                }
            }
        }
        return maxXor;
    }
}