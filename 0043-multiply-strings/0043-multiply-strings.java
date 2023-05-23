/** Math
* product[i + j + 1] = num1[i] * num2[j];
*/
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] product = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                product[i + j + 1] += a * b;
            }
        }
        
        //move carry to higher position
        int carry = 0;
        for (int i = m + n - 1; i >= 0; i--) {
            int d = product[i] + carry;
            product[i] = d % 10;
            carry = d / 10;
        }
        
        //remove the leading 0s
        int i = 0;
        while (i < product.length && product[i] == 0) i++;
        StringBuilder sb = new StringBuilder();
        while (i < product.length) sb.append(product[i++]);
        return sb.isEmpty()? "0" : sb.toString();
    }
}
//Time: O(m + n); Space: O(m + n)