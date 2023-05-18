/** Greedy **/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //check if the total gas greater than the total cost
        int sum = 0;
        for (int i = 0; i < gas.length; i++) sum += gas[i] - cost[i];
        if (sum < 0) return -1;
        
        //iterate over the array
        int start = 0, carry = 0;
        for (int i = 0; i < gas.length; i++) {
            carry += gas[i] - cost[i]; 
            
            //If station i+1 cannot be reached starting from start station, it means it cannot be reached starting 
            //any station between start and i. Then just move start to the next.
            if (carry < 0) {
                start = i + 1;
                carry = 0;
            }
        }
        return start;
    }
}
//Time: O(n); Space: O(1)
