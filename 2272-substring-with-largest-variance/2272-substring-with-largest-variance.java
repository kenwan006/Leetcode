/** Kadane's algorithm 
* Choose a pair of letters (major, minor), such as ('a', 'b')
* Iterate over the string s, if (c == major) majorCount++, if (c == minor) minorCount++;
* variance = majorCount - minorCount, the target is to find the max variance
*/
class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        
        int maxVar = 0;
        for (char major = 'a'; major <= 'z'; major++) {
            for (char minor = 'a'; minor <= 'z'; minor++) {
                if (major == minor) continue;
                
                int majorCtn = 0, minorCtn = 0, minorRem = freq[minor - 'a'];
                for (int i = 0; i < s.length(); i++) {//check the variance for the substring ending at s[i]
                    char c = s.charAt(i);
                    if (c == major) majorCtn++;
                    if (c == minor) {
                        minorCtn++;
                        minorRem--;
                    }
                    
                    //the case when maxVar might need to be updated
                    if (minorCtn > 0) {
                        maxVar = Math.max(maxVar, majorCtn - minorCtn);
                    }
                    
                    //the case when majorCtn and minorCtn need to be reset
                    if (majorCtn < minorCtn && minorRem > 0) {
                        majorCtn = 0;
                        minorCtn = 0;
                    }
                }
            }
        }
        return maxVar;
    }
}
//Time: O(n); Space: O(1)
