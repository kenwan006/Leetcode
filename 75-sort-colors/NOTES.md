lo - the rightmost boundary of 0s
hi - the leftmost boundary of 2s
cur - pointer to interate over the array
​
if nums[cur] == 0 swap element at cur and element at lo, move both lo and curr to the right;
if nums[cur] == 2 swap element at ucr and elemnt at hi, move hi to the left;
if nums[cur] == 1, only move curr to the right.