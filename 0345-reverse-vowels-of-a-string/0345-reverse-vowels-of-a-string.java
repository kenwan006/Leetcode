class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) set.add(c);
        
        int n = s.length();
        int i = 0, j = n - 1;
        StringBuilder sb = new StringBuilder(s);
        while (i < j) {
            //find the vowel from left to right
            while (i < j && !set.contains(s.charAt(i))) i++;
            //find the vowel from right to left
            while (i < j && !set.contains(s.charAt(j))) j--;
            
            if (i < j) {
                sb.setCharAt(i, s.charAt(j));
                sb.setCharAt(j, s.charAt(i));
                i++;
                j--;
            }
        }
        return sb.toString();
    }
}
//Time: O(n); Space: O(n)

