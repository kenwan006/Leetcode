/** HashMap *
* Calculate the slope between any two points
* Map<Double, Integer> - map a slope to the count of points on this slope
*/
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length, maxCount = 0;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                double slope = getSlope(points, i, j);
                map.putIfAbsent(slope, 0);
                map.put(slope, map.get(slope) + 1);
                maxCount = Math.max(maxCount, map.get(slope));
            }
        }
        return maxCount + 1;
    }
    
    private double getSlope(int[][] points, int i, int j) {
        int x1 = points[i][0], y1 = points[i][1];
        int x2 = points[j][0], y2 = points[j][1];
        
        if (x1 == x2) return Double.MAX_VALUE;
        if (y1 == y2) return 0;
        return 1.0 * (y1 - y2) / (x1 - x2);
    }
}
//Time: O(n * n); Space: O(n)
