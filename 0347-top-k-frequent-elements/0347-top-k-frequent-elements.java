/** Priority Queue + HashMap 
* Create a min heap of size k. Keep adding the num to the heap, if the size > k, then pop out the minimum on the top
* The heap always include the most frequent k elements 
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //Map num to its frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        //Create a min heap of size k and put the num to the heap based on their freq
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
            
        }
        
        //Get the most frequent k nums
        int[] res = new int[k];
        for (int i = 0; i < k; i++) 
            res[i] = heap.poll();
        
        return res;
    }
}

//Time: O(NlogK); Space: O(N + K)