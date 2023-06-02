class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //check if total gas can cover the cost
        int n = gas.length, sum = 0;
        for (int i = 0; i < n; i++) sum += gas[i] - cost[i];
        if (sum < 0) return -1;
        
        //find the start station
        int start = 0, carry = 0;
        for (int i = 0; i < n; i++) {
            carry += gas[i] - cost[i];
            if (carry < 0) {
                carry = 0;
                start = i + 1; //try to start from next station
            }
        }
        return start;
    }
}
//Time: O(n); Space: O(1)

