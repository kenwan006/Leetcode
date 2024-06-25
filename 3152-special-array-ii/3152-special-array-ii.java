class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        //split the nums into a group of non-intersected special subarray
        int n = nums.length;
        int[] group = new int[n]; //group[i] - groupId for the ith nums
        int idx = 0;
        group[0] = 0;
        for (int i = 1; i < n; i++) {
            if ((nums[i] + nums[i - 1]) % 2 == 0) idx++; //start a new group if adjacent two nums having different parity
            group[i] = idx;
        }
        
        int m = queries.length;
        boolean[] res = new boolean[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0], end = queries[i][1];
            if (group[start] == group[end]) res[i] = true;
        }
        
        return res;
    }
}