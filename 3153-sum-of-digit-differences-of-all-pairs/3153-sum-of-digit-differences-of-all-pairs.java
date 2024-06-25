class Solution {
    public long sumDigitDifferences(int[] nums) {
        long sum = 0;
        int n = nums.length;
        int len = String.valueOf(nums[0]).length();
        
        while (len-- > 0) {
            int[] count = new int[10]; // count of digit i at current position
            for (int i = 0; i < nums.length; i++) {
                count[nums[i] % 10]++;
                nums[i] /= 10;
            }
            
            for (int i = 0; i < 10; i++) {
                sum += 1L * count[i] * (n - count[i]);
            }
        }
        
        return sum / 2;
    }
}