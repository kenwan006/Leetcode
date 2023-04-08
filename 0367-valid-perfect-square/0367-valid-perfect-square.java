/** Binary Search **/
class Solution {
    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num; //use long type
        long mid, guess;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            guess = mid * mid;
            if (guess == num) return true;
            else if (guess > num) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}
//Time: O(log(n)); Space: O(1)