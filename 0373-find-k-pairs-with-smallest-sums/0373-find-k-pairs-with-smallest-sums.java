/** Heap *
* Initialize a queue with k items, fix nums2[0], and pari with nums1 -  {{nums1[0], nums2[0]},.., {nums1[k], nums2[0]}}
* Every time pop out the one with smallest sum, so {nums1[0], nums2[0]} will be the first pair to be popped
* The next pair to pop out is either from 
* A) -  {{nums1[1], nums2[0]},.., {nums1[k], nums2[0]}}, which is the exisiting queue,
* B) -  {nums1[0], nums2[1]}, pair nums1[0] with next smallest to nums2[0] in nums2, which is nums2[1]
*/
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        if (m == 0 || n == 0 || k == 0) return res;
        
        //initialize a queue - each item is an array including - nums1[i], nums2[j], j
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < m && i < k; i++) heap.offer(new int[]{nums1[i], nums2[0], 0});
        while (k > 0 && !heap.isEmpty()) {
            int[] curr = heap.poll();
            res.add(List.of(curr[0], curr[1])); //add the smallest pair to res
            
            int idx = curr[2];
            if (idx + 1 < n) heap.offer(new int[]{curr[0], nums2[idx + 1], idx + 1});
            
            k--;
        }
        return res;
    }
}
//Time: O(k * log(k)); Space: O(k)
