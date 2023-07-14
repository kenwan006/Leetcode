/** Sliding window **/
class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0; //count the points at the location
        for (List<Integer> point : points) {
            int dx = point.get(0) - location.get(0); 
            int dy = point.get(1) - location.get(1);
            if (dx == 0 && dy == 0) {
                count++;
                continue;
            }
            double deg = Math.atan2(dy, dx) * (180 / Math.PI); //concatenate to handle edge case
            angles.add(deg);
        }
        Collections.sort(angles);
        List<Double> temp = new ArrayList<>(angles);
        for (Double deg : temp) angles.add(deg + 360);
        
        //sliding window - [i, j]
        int maxCount = 0, i = 0;
        for (int j = 1; j < angles.size(); j++) {
            while (angles.get(j) - angles.get(i) > angle) i++;
            maxCount = Math.max(maxCount, j - i + 1);
        }
        return maxCount + count; 
    }
}
//Time: O(n); Space: O(n)
