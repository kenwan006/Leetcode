/** Heap 
* Initialize a min heap of the capacity k. Keep adding the val to the heap, the top item is always the smallest as well as kth largest in the heap
* Eg, k = 3, nums = [4, 5, 2, 8], the initial heap = [4, 5, 8], 4 is the smallest as well as 3rd largest in the heap;
* Adding a new item 6 to the heap, pop out 4, then it becomes [5, 6, 8], so 5 is the smallest as well as the 3rd largset in the heap...
* Remember all the items smaller than the kth largest item are poped!
*/

class KthLargest {
    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) { //constructor 
        this.heap = new PriorityQueue<>();
        this.k = k;
        
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) heap.poll();
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */