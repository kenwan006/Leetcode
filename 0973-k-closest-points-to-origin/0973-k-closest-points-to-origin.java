/** min heap **/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        for (int[] p : points) heap.offer(p);
        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = heap.poll();
        }
        return res;
    }
}
//Time: O(n * log(n)); Space: O(n)