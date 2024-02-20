class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, n = gas.length;
        for (int i = 0; i < n; i++) sum += (gas[i] - cost[i]); // check if the sum of all gas > sum of all cost
        if (sum < 0) return -1;
        
        //if total cost >= gas, we can always find a valid starting to travel around all stations
        // it can be proved intuitively
        int target = 0, carry = 0;
        for (int i = 0; i < n - 1; i++) {
            carry += gas[i] - cost[i];
            if (carry < 0) {
                target = i + 1;
                carry = 0;
            }
        }
        return target;
    }
}