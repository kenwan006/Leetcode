/** Sliding window + arrays or (hashmap)
Create a sliding window of the same size as string p
Use an array to count the letter in p; Use an array to count the letter in the sliding window;
Compare two arrays
*/
/*
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int[] countp = new int[26];
        int[] countsw = new int[26]; // sliding window counter
        
        if (s.length() < p.length()) return res;
        
        //Count the char freq in string p
        for (char ch : p.toCharArray()) countp[ch - 'a']++;
        
        //Move the sliding window
        int i = 0, j = 0;
        while (j < s.length()) {
            countsw[s.charAt(j) - 'a']++;
            
            // move the left boundary of the window to maintain its size
            if (j - i == p.length()) countsw[s.charAt(i++) - 'a']--; 
            
            if (Arrays.equals(countp, countsw)) res.add(i);
            
            j++;
        }
        return res;
    }
}
*/

/** Optimized sliding window method
* No need to use Arrays.equals() !!! But use a variable count;
* Use an array to store freq of each char in string p, and count to represent the total freq, which is same as p.length();
* Use two pointers, left and right, start moving right pointer and decrease the freq and count. When right - left == p.length() - 1, if count == 0, which means this windows matches; keeping moving right pointer, and also move left pointer. Before moving the left pointer, need to check if we have to add this char back to the freq.
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int[] freq = new int[26];
        int count = p.length();
        for (char ch : p.toCharArray()) freq[ch - 'a']++; 
        
        int left = 0, right = 0;
        while (right < s.length()) {
            //only the char existing in p has frequency > 0
            if (freq[s.charAt(right) - 'a'] > 0 ) count--; 
            
            //update the freq no matter if this char exist or not exist in p
            freq[s.charAt(right) - 'a']--; 
            
            //count == 0 means all chars in p have been visited
            if (count == 0) res.add(left);
            
            //when sliding window comes to the length of p, we have to update both left and right in the next move
            if (right - left == p.length() - 1) {
                //if the char was originally in the freq, then its frequence won't go below 0
                if (freq[s.charAt(left) - 'a'] >= 0) count++;
                freq[s.charAt(left) - 'a']++;
                left++;
            }
            
            right++;     
        }
        
        return res;      
    }
}
