class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
       return Math.max(height(red, blue), height(blue, red));
    }

    private int height(int red, int blue) {
        int height = 0;
        int row = 1;
        while (blue > 0 && red > 0) { //put blue at odd row, red at even row
            blue -= row;
            if (blue >= 0){
                row++;
                height++;
            } else break;

            red -= row;
            if (red >= 0) {
                row++;
                height++;
            } else break;
            
        }
        //if the next row is odd, then check if we can still put blue
        if (row % 2 == 1 && blue >= row) height++;
        return height;
    }
}