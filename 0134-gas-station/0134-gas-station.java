class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, sum = 0;
        // lefover of each station, and sum them up
        for (int i = 0; i < n; i++) {
            gas[i] -= cost[i];
            sum += gas[i];
        }
        if (sum < 0) return -1;
        
        //find the start station - that is guaranteed to be unique
        int carry = 0, start = 0;
        for (int i = 0; i < n; i++) {
            carry += gas[i];
            if (carry < 0) {
                carry = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
//Time: O(n); Space: O(1)
