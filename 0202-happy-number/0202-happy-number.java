class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        seen.add(n);
        
        while (n != 1) {
            n = get(n);
            if (seen.contains(n)) return false;
            seen.add(n);
            
        }
        return true;
    }
    
    private int get(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}