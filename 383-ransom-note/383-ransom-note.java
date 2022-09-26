/** Frequency counter
* similar to Leetcode 242
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] count = new int[26];
        for (char ch : magazine.toCharArray()) count[ch - 'a']++;
        for (char ch : ransomNote.toCharArray()) {
            if (count[ch - 'a'] == 0) return false;
            count[ch - 'a']--;
        }
        return true;
    }
}

