class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int x = i >= 0? num1.charAt(i--) - '0' : 0;
            int y = j >= 0? num2.charAt(j--) - '0' : 0;
            int z = x + y + carry;
            carry = z / 10;
            z %= 10;
            sb.append(z);
        }
        
        if (carry > 0) sb.append(carry);
        
        return sb.reverse().toString();
    }
}
//Time: O(n + m); Space: O(max(m, n));