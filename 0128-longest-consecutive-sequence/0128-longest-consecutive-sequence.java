/** HashSet
* Include all nums into a set
* In order to find a longest streak of numbers, we have to keep checking if num+1 is in the set. If yes then increment length by 1 and check the next num;
* Before we check num+1, we have to ensure num - 1 is not in the set, otherwise we have to start the check from num - 1. 
* eg nums = [1, 2, 4, 5, 6, 7, 10, 11], (not necessarily to be ordered). When num = 5, we should stop preceeding to the num + 1 = 6 because num - 1 = 4 is in the set , so we should check num = 4 first.
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //Create a set
        for (int num : nums) set.add(num);
        
        //find the longest streak starting from num
        int longest = 0;
        for (int num : nums) {
            int cur = 1;// length of the current streak starting from num
            if (!set.contains(num - 1)) {
                int next = num + 1;
                while (set.contains(next)) {
                    cur++;
                    next++;
                }
                longest = Math.max(longest, cur);
            }
        }
        return longest;    
    }
}

//Time: O(n); Space: O(n)