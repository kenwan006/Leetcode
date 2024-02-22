class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] product = new int[m + n]; // res[k] - sum of all possible num1[i] * num2[j] that i + j - 1 = k;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j  < n; j++) {
                product[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        //if the lower product is greater than 10, only keep the digit at ones place
        int carry = 0;
        for (int i = m + n - 1; i >= 0; i--) {
            int d = product[i] + carry;
            product[i] = d % 10;
            carry = d / 10;
        }
        
        //remove the leading zeros
        int i = 0;
        while (i < m + n && product[i] == 0) i++;
        String s = "";
        for (; i < m + n; i++) s += product[i];
        return s.isEmpty()? "0" : s;
    }
}