/** Two pointers 
* Iterate over the string s reversely
* pointer i points to the first non space char, and j points to the next space char, then one finds the word s[j + 1, i]
*/
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = n - 1;
        while (i >= 0) {
            //find the first non space 
            while (i >= 0 && s.charAt(i) == ' ') i--;
            
            if (i < 0) break; //break if the remainings are all space!!
            
            //find the next space 
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            
            //append the word
            sb.append(s.substring(j + 1, i + 1)).append(" "); //substring [ )
            i = j; //update i
        }
        
        sb.deleteCharAt(sb.length() - 1); //delete the redundant space at the end
        
        return sb.toString();
    }
}
//Time: O(n); Space: O(n), no extra space than n