class DetectSquares {
    int[][] freq;
    List<int[]> points;
    
    public DetectSquares() {
        freq = new int[1001][1001];
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        if (!points.contains(point)) points.add(point);
        freq[point[0]][point[1]]++;
    }
    
    public int count(int[] point) {
        int count = 0;
        int x = point[0], y = point[1];
        for (int[] p : points) {
            int x1 = p[0], y1 = p[1];
            if (x1 == x || y1 == y || Math.abs(x1 - x) != Math.abs(y1 - y)) continue;
            count += freq[x1][y] * freq[x][y1];
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */