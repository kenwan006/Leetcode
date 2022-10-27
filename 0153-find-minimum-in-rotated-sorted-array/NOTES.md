/** Binary Search
* If nums[mid] > nums[hi], the pivot (min num) is at right half because there must be a drop between mid and right.
- eg, {3, 4, 5, 6, 7, 1, 2}, lo=0, hi=6, mid=3, nums[mid]=6 > nums[hi]=2, then the min num must be in the right half
* If nums[mid] < nums[hi], the pivot (min num) is at the left half
- eg, Non rotated {1, 2, 3, 4, 5, 6, 7}, lo = 0, hi = 6, mid = 3, nums[mid]=4 < nums[hi]=7, then min must be in the left half
- eg, rotated {5, 6, 7, 1, 2, 3, 4}, nums[mid] = 1 < nums[hi] =4, then the min must be in the left half (including mid)
* If nums[mid] == nums[hi], this won't happen within the loop.
​