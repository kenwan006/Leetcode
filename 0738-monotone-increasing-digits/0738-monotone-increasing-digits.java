/** Greedy 
** Check from lower to higher, 
** For the pair of adjacent digits x and y (x in front of y), if x <= y, continue; if x > y, then change y to 9 and x--. eg, xy = 32, then we change it to 29
** Check from higher to lower to ensure each adjacent pair satisfy the x <= y requirement
*/

class Solution {
    public int monotoneIncreasingDigits(int n) {
        //convert n to a digit array
        if (n == 0) return 0;
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }
        
        int len = nums.size();
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) digits[len - i - 1] = nums.get(i);
        
        // revise the array to make x <= y for each pair of ajacent digits
        // check from lower to higher (right to left) digit
        for (int i = len - 2; i >= 0; i--) {
            if (digits[i] > digits[i + 1]) {
                digits[i + 1] = 9;
                digits[i]--;
            }
        }
        // check from higher to lower (left to right) digit
        int res  = digits[0];
        for (int i = 1; i < len; i++) {
            if (digits[i] < digits[i - 1]) digits[i]  = 9;
            res = res * 10 + digits[i];
        }
        return res;
        
    }
}
//Time: O(log(n)); Space: O(log(n))

