class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int minIdx = 0, maxIdx = 0; //min num and max num before nums[i] - inclusive
        int n = nums.length;
        //sliding window with size **indexDifference**, nums[i, j]
        for (int i = 0, j = indexDifference; j < n; i++, j++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
            
            if (nums[j] - nums[minIdx] >= valueDifference) return new int[]{minIdx, j};
            if (nums[maxIdx] - nums[j] >= valueDifference) return new int[]{maxIdx, j};
        }
        return new int[]{-1, -1};
    }
}
//Time: O(n); Space: O(n)