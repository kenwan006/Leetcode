/** Sliding window + arrays or (hashmap)
Create a sliding window of the same size as string p
Use an array to count the letter in p; Use an array to count the letter in the sliding window;
Compare two arrays
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int[] countp = new int[26];
        int[] countsw = new int[26];
        
        int ns = s.length(), np = p.length();
        if (ns < np) return res;

        // count the letter in string p
        for (char ch : p.toCharArray()) countp[ch - 'a']++;
        
        for (int i = 0; i < ns; i++) {
            countsw[s.charAt(i) - 'a']++;
            
            //To maintain the size of slising window, remove the left most if right most reach the bounds
            if (i >= np) countsw[s.charAt(i - np) - 'a']--;
            
            //Compare two arrays
            if (Arrays.equals(countsw, countp)) res.add(i - np + 1);
        }
        
        return res;
    }
}