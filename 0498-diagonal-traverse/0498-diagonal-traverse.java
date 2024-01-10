class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int r = 0, c = 0;
        for (int i = 0; i < m * n; i++) {
            res[i] = mat[r][c];
            
            //find the next cell
            if ((r + c) % 2 == 0) { //moving up
                if (c == n - 1) r++; //check if the right boundary is hit first
                else if (r == 0) c++;
                else {
                    r--;
                    c++;
                }
                
            } else { //moving down
                if (r == m - 1) c++; //check if the bottom bounday is hit first
                else if (c == 0) r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
//Time: O(m * n); Space: O(1)