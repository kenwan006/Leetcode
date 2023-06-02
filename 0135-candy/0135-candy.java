/** Two arrays *
* From left to right, find the uphill line, make sure the one has more candies than its neighbor to its left
* From right to left, find the uphill line, make sure the one has more candies then its neighbor to its right
* If ith rating has uphill neighbors to both left and right, then the candies needed for this child would be max{l2r[i], r2l[i]}
*/
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] l2r = new int[n];
        int[] r2l = new int[n];
        Arrays.fill(l2r, 1);
        Arrays.fill(r2l, 1);
        
        //check from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) l2r[i] = l2r[i - 1] + 1;
        }
        
        //check from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) r2l[i] = r2l[i + 1] + 1;
        }
        
        //determine the candiies for each child and accumulate them
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(l2r[i], r2l[i]);
        }
        return sum;
    }
}
//Time: O(n); Space: O(n)
