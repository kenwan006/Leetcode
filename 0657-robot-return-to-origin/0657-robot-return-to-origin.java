class Solution {
    public boolean judgeCircle(String moves) {
        int h = 0,  v = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') h++;
            else if (c == 'L') h--;
            else if (c == 'U') v++;
            else v--;
        }
        return h == 0 && v == 0;
    }
}
//Time: O(n); Space: O(1)
