/** Binary Search */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n; // start is 1
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) hi = mid; // do not use mid - 1 here because mid could be the goal
            else lo = mid + 1;
        }
        return lo;
    }
}