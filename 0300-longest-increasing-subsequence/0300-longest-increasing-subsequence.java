class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>(); //list - increasing subsequence
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) list.add(nums[i]); 
            else {
                int idx = binarySearch(list, nums[i]);
                list.set(idx, nums[i]);
            }
        }
        return list.size();
    }
    
    //find the first idx in the list where list.get(idx) > target
    private int binarySearch(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int num = list.get(mid);
            if (num < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}