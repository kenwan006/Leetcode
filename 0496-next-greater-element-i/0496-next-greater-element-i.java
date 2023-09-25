class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        //for each num in nums2, find the first greater element to its right
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) { //monotonically decrease
                int prev = stack.pop();
                map.put(prev, num); 
            }
            stack.push(num);
        }
        
        //for each num in nums1, check if the map contains the key
        int n = nums1.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums1[i])) res[i] = -1;
            else res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

//Time: O(n); Space: O(n)

