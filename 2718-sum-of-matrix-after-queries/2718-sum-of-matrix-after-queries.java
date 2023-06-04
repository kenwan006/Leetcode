/** Iterate reversely **/
class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        boolean[] cols = new boolean[n], rows = new boolean[n]; //mark if the row or col has been visited
        int colChange = 0, rowChange = 0; //number of changes 
        long sum = 0;
        
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0], index = queries[i][1], val = queries[i][2];
            if (type == 0 && !rows[index]) {
                sum += val * (n - colChange);
                rowChange++;
                rows[index] = true;
            }
            if (type == 1 && !cols[index]) {
                sum += val * (n - rowChange);
                colChange++;
                cols[index] = true;
            }
        }
        return sum;
    }   
}
//Time: O(n); Space: O(n)

