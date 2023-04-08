/** Binary Search *
* Sort the envolop by the width in ascending order. If with the same width, sort the height in desceding order!!
* Then this problem can be converted to a longest increasing subsequence problem. Find the LIS of the heights.
*/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //Sort the envolopes
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return b[1] - a[1];
                else return a[0] - b[0];
            }
        });
        
        //LIS - longest increasing subsequence
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            int width = envelopes[i][1];
            if (width > list.get(list.size() -1)) list.add(width);
            else binarySearch(list, width);
        }
        return list.size();
    }
    
    //Find the smallest item in the list >= target, and replace it with this target
    public void binarySearch(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) lo = mid + 1;
            else hi = mid;
        } 
        list.set(lo, target);
        return;
    }
}
//Time: O(n * log(n)); Space: O(n)