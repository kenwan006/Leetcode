class Solution {
    public int validSubarrays(int[] nums) {
        /**
        * Monotonic stack - increasing
        * eg, nums = [1, 4, 2, 5, 3]
        * num = 1, push to stak [1], we have one subarrays ending with 1, which has leftmost element to be min
        * num = 4, 4 > 1 so push to stack [1, 4], we have two subarrays ending with 4, [4] and [1,..,4]
        * num = 2, 2 < 4, pop 4 and push 2 to stack [1, 2], we have two subarrays ending with 2, [2] and [1...,2]
        * num = 5, 5 > 2, so push 5 to stack [1,2,5], we have three subarrats ending with 5, [5], [2..,5], [1..2..5]
        * num = 3, 3 < 5, pop 4 and push 3 to stack [1,2,3], we have three subarrays ending with 3, [3], [2..3], and [1..2..3]
        */
        
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) stack.pop();
            stack.push(num);
            count += stack.size();
        }
        
        return count;
        
    }
}