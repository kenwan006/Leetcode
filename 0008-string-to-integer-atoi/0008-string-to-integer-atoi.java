/** Iteration
* follow the rules
* 
*/
class Solution {
    public int myAtoi(String s) {
        int i = 0, len = s.length() - 1, sign = 1;
        
        //Remove the whitespace
        while (i <= len && s.charAt(i) == ' ') i++;
        
        //Read the sign '-' or '+', no-sign equivalent to '+'
        if (i <= len && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        
        int total = 0;
        // Read the digits
        while (i <= len) {
            int digit = s.charAt(i) - '0'; 
            if (digit < 0 || digit > 9) break; //check if it's a digit
            
            if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            i++;
        }
    
        return total * sign;
    }
}