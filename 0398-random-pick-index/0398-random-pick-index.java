class Solution {
    Map<Integer, Deque<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new LinkedList<>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        //get the index, remove it from front and add to the end for the future use
        int index = map.get(target).removeFirst();
        map.get(target).addLast(index);
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */