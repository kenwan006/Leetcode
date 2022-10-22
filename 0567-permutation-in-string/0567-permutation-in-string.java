/** Sliding window */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        //Target count and freq
        int[] freq = new int[26];
        int count = 0;
        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
            count++;
        }
        
        //Move the sliding window
        int i = 0;
        for (int j = 0; j < s2.length(); j++) {
            //check pointer j
            if (freq[s2.charAt(j) - 'a'] > 0) count--;
            freq[s2.charAt(j) - 'a']--;
            
            //move the left pointer to maintain the size of the sliding window
            if (j - s1.length() >=0) {
                if (freq[s2.charAt(i) - 'a'] >= 0) count++;
                freq[s2.charAt(i) - 'a']++;
                i++;
            }
            
            if (count == 0) return true;
        }
        
        return false;
    }
}

//Time: O(n); Space: O(1)