class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((p, q) -> q[0] * q[0] + q[1] * q[1] - p[0] * p[0] - p[1] * p[1]);
        
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