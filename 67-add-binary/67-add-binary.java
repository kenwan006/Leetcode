/** Bit by bit computation
* from lowest to highest (right to left)
*/

class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder s = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i >= 0) carry += a.charAt(i--) - '0';
            if (j >= 0) carry += b.charAt(j--) - '0';
            s.append(carry % 2);
            carry /= 2;
        }
        if (carry != 0) s.append(carry);
        return s.reverse().toString();
    }
}

