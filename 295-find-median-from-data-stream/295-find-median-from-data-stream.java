/* Two Heaps
* Use two heaps - large heap (Minheap) and small heap (Maxheap)
* All the numbers in the large heap is greater than numbers in small heap, the smallest number in large heap is on its top and largest number in the small heap is on its top.
* If current total number is even, then need to add a new num to small heap;
* If current total number is odd, then need to add a new num to large heap.
*/

class MedianFinder {
    Queue<Integer> smallHeap;
    Queue<Integer> largeHeap;
    boolean odd;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>();
        largeHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        if (odd) {
            smallHeap.add(num);
            largeHeap.add(smallHeap.poll());
            
        } else {
            largeHeap.add(num); // filter in large heap, then get the smallest number and add it to the small heap
            smallHeap.add(largeHeap.poll());
        }
        odd = !odd;
    }
    
    public double findMedian() {
        if (odd) return smallHeap.peek();
        return (largeHeap.peek() + smallHeap.peek()) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */