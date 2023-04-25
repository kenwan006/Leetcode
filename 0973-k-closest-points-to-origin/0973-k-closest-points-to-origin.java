/** max heap **/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) ->  b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int[] p : points) {
            heap.offer(p);
            if (heap.size() > k) heap.poll();
        }
        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = heap.poll();
        }
        return res;
    }
}
//Time: O(n * log(k)); Space: O(k)