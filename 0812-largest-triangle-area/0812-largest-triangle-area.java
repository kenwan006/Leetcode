class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0.0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = getArea(i, j, k, points);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
    
    //calculate the area of triangle formed by point i, j, k
    private double getArea(int i, int j, int k, int[][] points) {
        //we use p to reprsent the vector of i -> j, and q to represent vector of i ->k
        int[] p = new int[]{points[i][0] - points[j][0], points[i][1] - points[j][1]};
        int[] q = new int[]{points[i][0] - points[k][0], points[i][1] - points[k][1]};
        
        double cos = 1.0 * (p[0] * q[0] + p[1] * q[1]) / Math.sqrt((p[0] * p[0] + p[1] * p[1]) * (q[0] * q[0] + q[1] * q[1]));
        
        double sin = Math.sqrt(1 - cos * cos);
        
        return Math.sqrt((p[0] * p[0] + p[1] * p[1]) * (q[0] * q[0] + q[1] * q[1])) * sin * 0.5;
        
    }
}