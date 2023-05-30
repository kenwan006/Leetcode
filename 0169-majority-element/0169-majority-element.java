class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, buff = 0;
        for (int num : nums) {
            if (buff == 0) candidate = num;
                
            if (num == candidate) buff++;
            else buff--;
        }
        return candidate;
    }
}
//Time: O(n); Space: O(1)
