/** Sliding window
* use two pointer i and j to constrain the sliding window
* Check the max count of the sliding window every time moves the i or j. 
* eg. a string "AAABCD" k =2, in sliding window has max count = 3, i = 0, j = 4, maxLen = 5 when we change 'B' and 'C' to 'A'
* When j = 5, the maximum changes allowed is j - i + 1 - maxcount = 5 - 0 + 1 - 3 = 3 > k, so we have to move pointer i to 1. When moving i, we have to update the max count because 'A' at i = 0 was moved out of the window, so max count = 2. And check j - i + 1 - maxcount again..
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, maxCount = 0, maxLen = 0;
        int[] count = new int[26];
        for (int j = 0; j < s.length(); j++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(j) - 'A']);
            while (j - i + 1 - maxCount > k) {//the windows requires more than k changes, then move left pointer i
                count[s.charAt(i) - 'A']--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}

//Time: O(n); Space: O(1)