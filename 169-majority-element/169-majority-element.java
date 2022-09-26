/** Boyer- Moore Voting
* Remember the premise is there exists such majority item!
* We define a count as a marker
* Iterate over the nums, when count = 0, choose current num as the candidate. Keep checking the next num, if equals to candidate, then count++, otherwise count--. 
* Because there exists such majority item, which means the target item has more frequency than the total appearance of all the other non candidates, so we can assure the candidate by the end of the iterations will be the target. 
eg,[7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7] target = 7
eg,[7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 5, 5, 5, 5] target = 5
*/
class Solution {
    public int majorityElement(int[] nums) {
        Integer candidate = null; // do not use 0 because num could be negative
        int count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }
}