class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] leftCandle = new int[n]; //leftCandle[i] - nearest candle to the left of ith char
        int left = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                left = i;
            }
            leftCandle[i] = left;
        }
        
        int[] rightCandle = new int[n]; //rightCandle[i] - nearest candle to the right of ith char
        int right = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                right = i;
            }
            rightCandle[i] = right;
        }
        
        //prefix sum - check the count of '|' before the current position
        int[] prefixSum = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') count++;
            prefixSum[i] = count;
        }
        
        //for each query, find nearest to right of query start, nearest to the left of query end
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];
            int leftBound = rightCandle[start];
            int rightBound = leftCandle[end];
            if (leftBound == -1 || rightBound == -1 || rightBound - leftBound <= 1) res[i] = 0;
            else res[i] = rightBound - leftBound - 1 - (prefixSum[rightBound] - prefixSum[leftBound] - 1); 
        }
        
        return res;
    }
}

//Time: O(n + m); Space: O(n)
