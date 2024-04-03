class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(List.of('a', 'e','i', 'o', 'u'));
        
        int max = 0;
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char cr = s.charAt(i);
            if (set.contains(cr)) count++;
            if (i >= k) {
                //remove the left most char fromo the sliding window
                char cl = s.charAt(i - k);
                if (set.contains(cl)) count--;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}
//Time: O(n); Space: O(1)

