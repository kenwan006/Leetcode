/** Greedy **/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b) {
                int result = Integer.compare(b[0], a[0]);
                if (result == 0) result = Integer.compare(a[1], b[1]);
                return result;
            }
        };
        // Sort the height in descending order
        // For the same height, sort the k in ascending order
        Arrays.sort(people, comparator); 
        
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

