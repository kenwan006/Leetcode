/* DP *
* dp[i] - the min total height for placing all first ith books, eg, dp[2] is for book[0], book[1]
* For the ith book, either place it on a new shlef, dp[i] = dp[i - 1] + height[i - 1] //use i-1 not i since it's 1-indexed
* or grab books from previous shelf and put thme on to a new shelf together with ith book, but make sure total width <= shelfWidth for each shelf
* min{dp[j-1] + max{height[k], k in range of [j..i-1]}} for j in range of (0..i-1]
*/
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1]; //use n+1 not n for convenience when i = 0
        
        for (int i = 1; i <= n; i++) {
            //init the width and height for the new shelf
            int width = books[i - 1][0];
            int height = books[i - 1][1];
            
            //either put ith(1-indexed) book on the new shelf
            dp[i] = dp[i - 1] + height;
            
            //or grab books from previous shelf and put them to the new shelf together with ith book
            for (int j = i - 1; j > 0 && width + books[j - 1][0] <= shelfWidth; j--) {
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], height + dp[j - 1]); //remember height is for range height[j..i-1]
                width += books[j - 1][0]; 
            }
        }
        return dp[n];
    }
}
//Time: O(n); Space: O(n)
