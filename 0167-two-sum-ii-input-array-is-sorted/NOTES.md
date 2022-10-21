Must use only constant extra space, so hashmap is not an option in this case.
But since this array is sorted, so we can use two pointers to check the left and right at the same time.
/** Two pointers
* if nums[l] + nums[r] > target, move r to left by 1;
* if nums[l] + nums[r] < target, move l to the right by 1;
* if nums[l] + nums[r] == target, return [l, r]
*/