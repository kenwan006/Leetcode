class Solution {
    public int myAtoi(String s) {
        int index = 0, total = 0, sign = 1, len = s.length();
        
        if (len == 0) return 0;
        
        //Remvoe the space
        while(index < len && s.charAt(index) == ' ' ) index++;
        
        //Read the sign
        if(index < len && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        
        //Read the digits
        while(index < len) {
            int digit = s.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            //check if integer is in the range
            if(total > Integer.MAX_VALUE / 10 || 
              (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }
        return total * sign;
    }
}
           