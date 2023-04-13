class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //construct a max heap with size k
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]));
        for (int[] p : points) {
            heap.add(p);
            if (heap.size() > k) heap.poll();
        }
        
        //pop out all k points in the heap
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) res[i] = heap.poll();
        return res;
    }
}
//Time: O(n * log(k)); Space: O(k)