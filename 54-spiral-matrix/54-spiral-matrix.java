class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = m - 1, up = 0, down = n - 1;
        
        while(res.size() < n * m) {
            // move towards right
            for (int j = left; j <= right && res.size() < n * m; j++) {
                res.add(matrix[up][j]);
            }
            
            // move downwards
            for (int i = up + 1; i <= down && res.size() < n * m; i++) {
                res.add(matrix[i][right]);
            }
            
            // move towards left
            for (int j = right - 1; j >= left && res.size() < n * m; j--) {
                res.add(matrix[down][j]);
            }
            
            // move upwards
            for (int i = down -1; i >= up + 1 && res.size() < n * m; i--) {
                res.add(matrix[i][left]);
            }
            
            left++; right--; up++; down--;
        }
        return res;
    }
}