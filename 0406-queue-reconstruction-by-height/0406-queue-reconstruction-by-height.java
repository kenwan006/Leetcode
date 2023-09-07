/** Greedy **/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort the height in descending order
        // For the same height, sort the k in ascending order
        Arrays.sort(people, (a, b) -> a[0] == b[0]? a[1] - b[1] : b[0] - a[0]); 
        
        // Insert each person to the right place
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            int index = p[1];
            list.add(index, p);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
//Time: O(n * n); Space: O(n)

