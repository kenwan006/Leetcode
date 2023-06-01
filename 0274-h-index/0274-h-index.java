class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length, m = citations[n - 1]; //m is the max citation
        
        int[] count = new int[m + 1]; //count[i] - count of papers that has citations >= i
        
        for (int i : citations) count[i]++; //initialized
        
        for (int i = m; i > 0; i--) {
            if (count[i] >= i) return i;
            count[i - 1] += count[i];
        }
        return 0;
    }
}
//Time: O(n * log(n) + m); Space: O(m) 