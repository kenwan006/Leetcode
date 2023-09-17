class Solution {
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();
        long max = 0;
        for (int i = 1; i <= n; i++) {
            long sum = completeSum(i, n, nums);
            max = Math.max(max, sum);
        }
        return max;
    }
    //the complete subsets of indices is like: 1 * 1^2 + 1 * 2^2 + 1 * 3^3.. for base =1
    // the base could be in range of [1, n]
    private long completeSum(int base, int n, List<Integer> nums) {
        long sum = 0;
        int count = (int) Math.sqrt(n / base);
        for (int i = 1; i <= count; i++) {
            int index = base * i * i - 1; //1-indexed
            sum += nums.get(index);
        }
        return sum;
    }
}
//Time: O(n * sqrt(n)); Space: O(1)
