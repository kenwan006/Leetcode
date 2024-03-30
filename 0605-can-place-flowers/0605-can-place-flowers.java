class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) continue;
            if (i > 0 && flowerbed[i - 1] == 1) continue;
            if (i < m - 1 && flowerbed[i + 1] == 1) continue;
            flowerbed[i] = 1;
            count++;
        }
        return count >= n;
    }
}
//Time: O(n); Space: O(1)

