/** Hashset 
* All the cells board[r][c] in the 3 x 3 sub-box have the same box index (r/3, c/3)
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>(); // the string is like "num is at row r"
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++ ) {
                char ch = board[r][c];
                if (ch == '.') continue;
                if (set.contains(ch + " is in column" + c) || 
                    set.contains(ch + " is in row" + r) || 
                    set.contains(ch + " is in box " + c/3 + "-" + r/3))
                    return false;
                set.add(ch + " is in column" + c);
                set.add(ch + " is in row" + r);
                set.add(ch + " is in box " + c/3 + "-" + r/3);
            }
        }
        return true;
    }
}

//Time: O(N^2); Space: O(N^2)