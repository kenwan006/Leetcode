class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l = 0, r = points.length - 1;
        while(l < r) {
            int mid = helper(points, l, r);
            if(mid == k) break;
            if(mid < k) l = mid + 1;
            else r = mid - 1;
        }
        return Arrays.copyOfRange(points, 0, k);
    }
    
    public int helper (int[][] points, int l, int r) {
        int p = l; // pick the pivot
        while(l < r) {
            while(l < r && compare(points[r], points[p]) > 0) r--;
            while(l < r && compare(points[l], points[p]) <= 0) l++;
            swap(points,l, r);
        }
        swap(points, p, l); // put pivot to where the loop stops when l = r.
        return l;
    }
    
    public int compare(int[] p0, int[] p1) {
        return p0[0] * p0[0] + p0[1] * p0[1] - p1[0] * p1[0] - p1[1] * p1[1];
    } 
    
    public void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}