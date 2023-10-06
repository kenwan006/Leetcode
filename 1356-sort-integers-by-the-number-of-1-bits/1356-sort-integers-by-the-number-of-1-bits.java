class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[] :: new);
        Arrays.sort(nums, (a, b) -> countOne(a) == countOne(b)? a - b : countOne(a) - countOne(b));
        
        for (int i = 0; i < arr.length; i++) arr[i] = nums[i];
        return arr;
    }
    
    private int countOne(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }
}
//Time: n * log(n); Space: O(n)
