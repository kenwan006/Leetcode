/** Greedy **/
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = {0, 0, 0};
        for (int[] t : triplets) {
            //Any element in a triplet greater than the target should not be a candidate
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;
            res[0] = Math.max(res[0], t[0]);
            res[1] = Math.max(res[1], t[1]);
            res[2] = Math.max(res[2], t[2]);
        }
        return Arrays.equals(res, target);
    }
}
//Time: O(n); Space: O(1)