/** Two pointers
* Let's get something to know first. For a descent sequance, Eg, [6, 5, 4, 2, 1], we can't find a greater permuation lexicographically greater than it!
* Use a pointer i to iterate over the nums, i starts from the end of the array and move backward;
* Keep moving until nums[i] > nums[i-1]. As of now, nums[i,..,end] is a descent sequence, nums[i-1, i] is a ascent sequence. Sequence[i..end] does not have next permuation, but sequence[i-1, end] does have.
* Find a position j among [i, end] that nums[j] is the smallest item greater than num[i-1], then swap nums[i] and nums[j]
* After the swap, reverse the sequence nums[i, end] because this sequence is still in descent order, reverse it so one can get a smallest permuation.
* eg, nums=[9,3,6,5,4,2,1], n = 7, i stops at i=2, nums[i] =6, nums[i-1]=3, nums[j]=4 (1st item >= nums[i-1]), swap 3 and 4 =>[9,4,6,5,3,2,1], then reverse [6,5,3,2,1] => [9,4,1,2,3,5,6]
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        
        //find the peak from right to left
        int i = n - 1;
        while (i > 0) {
            if (nums[i - 1] < nums[i]) break;
            i--;
        }
        
        //original nums is completely descent [5,4,3,2,1] -> [1,2,3,4,5]
        if (i == 0) {
            reverse(nums, 0, n - 1);
            return;
        } 
        
        //find j
        int j = n - 1;
        while (j >= i) {
            if (nums[j] > nums[i - 1]) break;
            j--;
        }
        
        //swap i-1 and j, and reverse [i..end]
        swap(nums, i - 1, j);
        reverse(nums, i, n - 1);
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int lo, int hi) {
        while (lo <= hi) swap(nums, lo++, hi--);
    }
}
//Time: O(n); Space: O(1)