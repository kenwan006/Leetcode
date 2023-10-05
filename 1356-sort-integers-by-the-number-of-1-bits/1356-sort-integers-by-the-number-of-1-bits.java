class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[][] counts = new int[n][2];
        for (int i = 0; i < n; i++) {
            counts[i][0] = countOne(arr[i]);
            counts[i][1] = arr[i];
        }
        
        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                else return Integer.compare(a[0], b[0]);
            }
        };
        
        Arrays.sort(counts, comparator);
        for (int i = 0; i < n; i++) arr[i] = counts[i][1];
        return arr;
    }
    
    private int countOne(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }
}
//Time: n * log(n); Space: O(n)
