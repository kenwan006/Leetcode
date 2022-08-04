class Solution {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum / 2 == 1 ? 1 : 0;
            s.append(sum % 2);
        }
        if (carry != 0) s.append(1); // check if the last carry 
        return s.reverse().toString();     
    }
}