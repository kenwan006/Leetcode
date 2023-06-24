/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }
    
    private Node construct(int[][] grid, int i, int j, int len) { //[i, j] - refers to the topleft cell of current grid
        if (len == 1) return new Node(grid[i][j] == 1, true);
        
        Node topLeft = construct(grid, i, j, len / 2);
        Node topRight = construct(grid, i, j + len / 2, len / 2);
        Node bottomLeft = construct(grid, i + len / 2, j, len / 2);
        Node bottomRight = construct(grid, i + len / 2, j + len / 2, len / 2);
        
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf 
                    && topLeft.val == topRight.val && topRight.val == bottomLeft.val 
                    && bottomLeft.val == bottomRight.val) return new Node(topLeft.val, true);
        
        //it's also ok to set val = true when isLeaf if false
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight); 
    }
}
//Time: O(n * n); Space: O(log(n))
