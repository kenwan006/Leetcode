class Solution {
    public int balancedStringSplit(String s) {
        int res = 0;
        int count = 0; //count how many L needed to balance current substring
        
        for (char c : s.toCharArray()) {
            if (c == 'R') count++;
            else count--;
            
            if (count == 0) res++;
        }
        return res;
    }
}
//Time: O(n); Space: O(1)