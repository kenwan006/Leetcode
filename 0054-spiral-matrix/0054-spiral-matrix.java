class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        int capacity = m * n;
        List<Integer> res = new LinkedList<>();
        
        while (res.size() < capacity) {
            // move towards right
            for (int j = left; j <= right && res.size() < capacity; j++) {
                res.add(matrix[top][j]);
            }
            
            // move downwards
            for (int i = top + 1; i <= bottom && res.size() < capacity; i++) {
                res.add(matrix[i][right]);
            }
            
            //move towards left
            for (int j = right - 1; j >= left && res.size() < capacity; j--) {
                res.add(matrix[bottom][j]);
            }
            
            //move upwards
            for (int i = bottom - 1; i > top && res.size() < capacity; i--) {
                res.add(matrix[i][left]);
            }
            
            //update boundaries
            top++; right--; bottom--; left++;
        }
        return res;
    }
}