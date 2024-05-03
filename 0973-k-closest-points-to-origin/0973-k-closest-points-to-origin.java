class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int[] p : points) {
            heap.offer(p);
            if (heap.size() > k) heap.poll();
        }
        
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}

//Time: O(n * log(k)); Space: O(n)

