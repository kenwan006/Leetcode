/* Two Heaps
* Use two heaps - large (Minheap) and  small (Maxheap)
* The large heap inclued larger half of all nums, and small heap includes smaller hlaf of al nums. All the numbers in the large heap is greater than numbers in small heap, the smallest number in large heap is on its top and largest number in the small heap is on its top.
* If current total number is even, then need to add a new num to small heap;
* If current total number is odd, then need to add a new num to large heap.
*/

class MedianFinder {
    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;
    boolean odd; // used to decide to which heap the new num should be added 

    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>((a, b) -> (b - a));
    }
    
    public void addNum(int num) {
        if(odd) {
            small.add(num); // new number has to be filtered in small heap cuz it could be < than the largest in small heap
            large.add(small.poll()); // put the largest num from small heap back to large heap as its smallest num
        } else {
            large.add(num); 
            small.add(large.poll()); 
        }
        odd = !odd;
    }
    
    public double findMedian() {
        if (odd) return small.peek(); // when current total is even, we add new num to the small heap, then the new total would be odd;
        else return (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */