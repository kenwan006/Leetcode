/** max Heap */

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
        // create the initial heap
        for (int stone : stones) heap.offer(stone);
        
        // pop out the largest two stones each time
        while (heap.size() > 1) {
            int y = heap.poll();
            int x = heap.poll(); //y >= x
            if (y > x) heap.offer(y - x); 
        }
        
        return heap.size() == 0? 0 : heap.peek();
    }
}

//Time: O(n); Space: O(n)
