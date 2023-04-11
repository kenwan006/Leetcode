/** Radix Sort 
* Reference the visualization - https://www.cs.usfca.edu/~galles/visualization/RadixSort.html
*/
class Solution {
    private static final int R = 10;
    
    public int maximumGap(int[] nums) {
        //find the max num and determine how many digits a num could have at most
        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        
        int n = nums.length;
        if (n < 2) return 0;
        int[] aux = new int[n]; //auxiliary array to the nums
        int exp = 1; //exp = 1, 10, 100,...
        
        while (max / exp > 0) {
            //count the digits at current position (ones, tens, hundres...)
            int[] count = new int[R];
            for (int num : nums) {
                count[(num / exp) % 10]++;
            }
            
            //accumulate the counts by adding its previous counts
            for (int i = 1; i < R; i++) {
                count[i] += count[i - 1];
            }
            
            //iterate over the nums reversely and put each num to the aux array
            for (int i = n - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % 10]] = nums[i];
                //count decrease by one as one num moved to aux
            }
            
            //put nums in axu back to nums
            for (int i = 0; i < n; i++) nums[i] = aux[i];
            
            exp *= 10; 
        }
        
        //find the max gap in a sorted array
        int res = 0;
        for (int i = 1; i < n; i++) res = Math.max(res, nums[i] - nums[i - 1]);
        return res;
    }
}
//Time: O(n); Space: O(1)