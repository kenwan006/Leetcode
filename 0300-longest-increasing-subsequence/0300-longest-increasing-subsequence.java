/** Binary Search *
* If nums = [1,7,8,4,5,9,6], iterate over the nums, when one walks to i = 2, the LIS =[1,7,8], the length of LIS is 3.
* Check the next i=3, if nums[i]=9, definitely add it to the LIS, then length increases by one. 
* But now nums[i]=4 < 8, then we have find a position to put this 4. By using binary search, find the postion=1, which means 7 will be replaced by 4, therefore LIS = [1,4,8], the longest length of LIS is still 3.
* Check the next one i=4, nums[i]=5 < 8, then binary seach find the position=2, which means 8 in the LIS will be replaced by 5. Then LIS = [1,4,5]
* Check the next one i=5, nums[i]=9 > 5 (the top item in the LIS), add 9 to the LIS, then LIS =[1,4,5,9]
* Everytime compare with the top item (largest), if it's greater than the top item, then add to the LIS, if not, find an item in the LIS to replace..
* Note: LIS is not necessarily the exactly the longest increasing subsequence, but they have the same length!!
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]); //initailize
        for (int i = 1; i < nums.length; i++) {
            // push num to the list if it's greater than the top item in the list
            if (nums[i] > list.get(list.size() - 1)) { 
                list.add(nums[i]);
            }
            // otherwise binary search to find the position to replace in the list
            binarySearch(list, nums[i]);
        }
        return list.size();
    }
    
    //find the smallest num >= target, then replace it with the target
    public void binarySearch(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target)lo = mid + 1;
            else hi = mid;
        }
        list.set(lo, target);
    }
}
//Time: O(n * log(n)); Space: O(n)