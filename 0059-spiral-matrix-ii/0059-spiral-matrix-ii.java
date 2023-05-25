class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top  = 0, bottom = n - 1, left = 0, right = n - 1;
        int index = 1, capacity = n * n;
        
        while (index <= capacity) {
            //walk from left -> right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = index++;
            }
            top++;
            
            //walk from top -> bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = index++;
            }
            right--;
            
            //walk from right -> left
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = index++;
            }
            bottom--;
            
            //walk from bottom -> up
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = index++;
            }
            left++;
        }
        return matrix;
    }
}
//Time: O(n * n); Space: extra O(1)

