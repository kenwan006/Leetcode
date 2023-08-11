/** Greedy + Binary Search **/
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int lo = 1, hi = maxSum;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2; //do not use (lo + hi)/2 to avoid infinite loop
            long sum = getSum(n, index, mid);
            if (sum > maxSum) {
                hi = mid - 1;
            }
            else {
                lo = mid;
            }
        }
        return lo;
    }
    
    //return sum of n positive numbers with max number at index =i
    //left part is ascending and right part is descending
    public long getSum(int n, int i, int max) {
        long sum = 0;
        //left half - from 0th to ith, which is ..max-2, max-1, max
        if (max > i) {
            sum += (long)(max + max - i) * (i + 1) / 2;
        } else {
            sum += (long)(max + 1) * max / 2 + (i + 1 - max);
        }
        
        //right half - from ith to (n-1)th, which is max, max-1, max-2..
        if (max >= n - i) {
            sum += (long)(max + max - n + i + 1) * (n - i) / 2;
        } else {
            sum += (long)max * (max + 1) / 2 + (n - i - max);
        }
        
        return sum - max; //max was added twice
    }
}

//Time: O(log(maxSum)); Space: O(1)
