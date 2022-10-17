/** Two pointers
* The trapped water is decided by the its left max height and right max height.
* If lmax <= rmax, then check the left block because the water will not even flow over lmax;
* otherwise lmax > rmax, then check the right block because the water will not even flow over rmax
*/
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, lmax = 0, rmax = 0, res = 0;
        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if (lmax <= rmax) {
                res += lmax - height[l];
                l++;
            } else {
                res += rmax - height[r];
                r--;
            }  
        }
        
        return res;
    }
}