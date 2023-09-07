class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] count = new int[2]; //count of $5 and $10
        for (int bill : bills) {
            if (bill == 5) {
                count[0]++;
            } else if (bill == 10) {
                count[1]++;
                if (--count[0] < 0) return false;
            } else {
                if (count[1] > 0) {
                    count[1]--;
                    count[0]--;
                } else {
                    count[0] -= 3;
                }
                if (count[0] < 0) return false;
            }
        }
        return true;
    }
}
//Time: O(n); Space: O(1)
