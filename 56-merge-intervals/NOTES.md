- We have to sort the given intervals in an ascending order, using:
Arrays.sort(array, comparator)
​
- How do we merge two intervals, which are already sorted by their starts ?
Tryting to merge a new interval [start2. end2] to [start1, end1],  start <= start2....
If start2 > end1  then we have to add this interval ==> [start1, end1], [start2, end2]
If start2 < end1 < end2 then we have to update the end ==> [start1, end2]
If end1 > end 2 then no change to the interval ==> [start1, end1]