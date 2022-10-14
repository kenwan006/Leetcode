/** Sliding window + arrays or (hashmap)
Create a sliding window of the same size as string p
Use an array to count the letter in p; Use an array to count the letter in the sliding window;
Compare two arrays
*/
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

/*
/** Optimized sliding window method
* No need to use Arrays.equals() !! But use a count;
* Use a array to store freq of each char in string p, and count to represent the total freq, which is same as p.length();
* Use two pointers, left and right, start moving right pointer and updating the freq and count
*/
/*
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
      
    }
}
*/