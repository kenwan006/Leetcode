class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            carry += digits[i];
            list.add(0, carry % 10);
            carry /= 10;
        }
        if (carry > 0) list.add(0, carry);
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
}
//Time: O(n); Space: O(n)

