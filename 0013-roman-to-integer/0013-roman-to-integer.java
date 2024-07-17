class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int res = 0, n = s.length();
        for (int i = 0; i < n - 1; i++) {
            int num1 = map.get(s.charAt(i)), num2 = map.get(s.charAt(i + 1));
            if (num1 < num2) res -= num1;
            else res += num1;
        }
        res += map.get(s.charAt(n - 1));
        return res;
    }
}