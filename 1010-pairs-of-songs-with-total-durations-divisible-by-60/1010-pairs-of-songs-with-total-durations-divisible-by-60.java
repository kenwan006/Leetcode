/** Hashtable *
* When sum of the remainders of two number is divisible by 60, then sum of these two number is divisible by 60. 
* eg, ((a % 60) + (b % 60)) % 60 = 0  -> (a + b) % 60 = 0
*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[61]; // freq of remainder
        int count = 0;
        
        for (int t : time) {
            if (t % 60 == 0) count += remainder[0];
            else count += remainder[60 - t % 60];
            
            remainder[t % 60]++;
        }
        
        return count;
    }
}
//Time: O(n); Space: O(1)