/** Two pointers + Sliding window
* Use two poniters: i- start and j- end starting from 0
* Move end pointer until find a valid window, which contains all char in string t
* Move start one by one to shirnk the window
* Repeate the above 2 steps to find the shortest window
*/

class Solution {
    public String minWindow(String s, String t) {
        int i = 0, j = 0, min_i = 0, minLen = Integer.MAX_VALUE; // two pointers for the sliding window
        
        //Create an array to map each char in t to its frequency
        int[] map = new int[58];
        int count = 0;
        for (char ch : t.toCharArray()) {
            map[ch - 'A']++; // 'A' < 'a'
            count++;
        }
        
        //Move end until find a valid window - including all chars from t
        while (j < s.length()) {
            if (map[s.charAt(j) -'A'] > 0) count--;
            map[s.charAt(j) - 'A']--; //update the freq
            
            //shrink the window by moveing the left boundary
            while (count == 0) {
                map[s.charAt(i) - 'A']++;
                if (map[s.charAt(i) - 'A'] > 0) count++;//only the freq of char in t could go beyond 0
                    
                if (j - i + 1 < minLen) {
                    min_i = i;
                    minLen = j - i + 1;
                }
                i++;
            }
            
            j++;
        }
        if (min_i + minLen > s.length()) return "";
        return s.substring(min_i, min_i + minLen);
        
    }
}