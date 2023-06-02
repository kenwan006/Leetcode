class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        int n = s.length();
        dict.put('I', 1); 
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        
        int res = dict.get(s.charAt(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            char c = s.charAt(i), c1 = s.charAt(i + 1);
            if (dict.get(c) >= dict.get(c1)) res += dict.get(c);
            else res -= dict.get(c); // smaller number in front of larger number, then deduct this smaller number
        }
        return res;
    }
}
//Time: O(n); Space: O(1)
