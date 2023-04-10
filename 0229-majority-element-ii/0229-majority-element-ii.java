/**  Boyer- Moore Voting */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //There are at most two candidates with appearance more than n/3
        int candidate1 = 0, candidate2 = 1; //initialize two candidates with different numbers
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        //second pass to check if candidates are valid
        count1 = 0;
        count2 = 0;
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (num == candidate1) count1++;
            if (num == candidate2) count2++;
        }
        
        int n = nums.length;
        if (count1 > n / 3) res.add(candidate1);
        if (count2 > n / 3) res.add(candidate2);
        return res;
    }
}
//Time: O(n); Space: O(1)