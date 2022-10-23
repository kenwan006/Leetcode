/** Sliding windonw + deque
* define sliding window [1, j] of size k, so i = j - k + 1;
* define a deque dq, put index of the maximum num into the front of dq. When adding a new item j to dq, make sure pop out all the item x that nums[x] < num[j], so the deque is monotonic queue, max is at the head, second at next, an so on so forth.
* Every tiem adding a new element to the deque, check if the most front element is within the range of current sliding windown[i, j]. If not pop it out from the deque.
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        
        for (int j = 0; j < nums.length; j++) {
            int i = j - k + 1; //left pointer of the window
            
            // pop out the front element if it's out of the window
            if (!dq.isEmpty() && dq.peek() < i) dq.remove();
            
            // adding new item j to the tail of dq and pop out all x that nums[x] < num[j]
            while (!dq.isEmpty() && nums[j] > nums[dq.peekLast()]) dq.removeLast();
            dq.add(j);
            
            // add the max num in current window to the result
            if (i >= 0) res[i] = nums[dq.peek()];
        }
        return res;
    }
}

// Time: O(n); Space: O(n)