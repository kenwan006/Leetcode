class Solution {
    public int getMaxLen(int[] nums) {
        int max = 0;
        int positive = 0; //length of positive product
        int negative = 0; //length of negative product
        /**
        * eg, we have [-1,2,3],len of positive product is 2 and len of negative product is 3. Now add a new num
        * if num > 0, say num = 2, then len of pos product 2 + 1 = 3, len of neg product 3 + 1 = 4. Special case is,
        * we have [2, 3], len of posi product is 0, adding new num =2, we still have len of neg product to be 0, not 0 + 1 =1
        * if num < 0, analyze the similar way, but need to swap!!
        * if num = 0, reset both pos and neg
        **/
        
        for (int num : nums) {
            if (num > 0) {
                positive++;
                negative = negative == 0? 0 : negative + 1;
            } else if (num < 0) {
                int temp = positive;
                positive = negative == 0? 0 : negative + 1;
                negative = temp + 1;
            } else {
                negative = 0;
                positive = 0;
            }
            max = Math.max(max, positive);
        }
        return max;
    }
}

//Time: O(n); Space: O(1)
