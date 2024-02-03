class Solution {
    public long flowerGame(int n, int m) {
        //choose x from [1, n], y from [1, m]. |x - y| = 1, 3, 5...
        long res = 0;
        
        for (int x = 1; x <= n && x <= m; x++) {
            //choose y from [x + 1, m] that y - x = 1, 3, 5..
            res += (m - x + 1) / 2;
        }
        
        for (int y = 1; y <= m && y <= n; y++) {
            //choose x from [y + 1, n] that x - y = 1,3,5..
            res += (n - y + 1) / 2;
        }
        
        return res;
    }
}

