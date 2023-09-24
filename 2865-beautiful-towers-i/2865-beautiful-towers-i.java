class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
       int n = maxHeights.size();
        long res = 0;
        for (int index = 0; index < n; index++) {
            long sum = 0;
            int min = maxHeights.get(index);
            sum += min;
            for (int i = index - 1; i >= 0; i--) {
                if (maxHeights.get(i) < min) min = maxHeights.get(i);
                sum += min;
            }
            min = maxHeights.get(index);
            for (int i = index + 1; i < n; i++) {
                if (maxHeights.get(i) < min) min = maxHeights.get(i);
                sum += min;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
//Time: O(n * n); Space: O(1)