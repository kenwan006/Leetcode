/** Greedy **/
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        //scan from left to right, +1 if it has higher rating than left neighbor
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }
        
        //scan from right to left, +1 if it has higher rating than right neighbor
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
        
        int sum = 0;
        for (int candy : candies) sum += candy;
        return sum;
    }
}
//Time: O(n); Space: O(n)

