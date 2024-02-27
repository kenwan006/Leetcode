class SparseVector {
    int[] vector;
    SparseVector(int[] nums) {
        vector = Arrays.copyOf(nums, nums.length);
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        for (int i = 0; i < vector.length; i++) {
            product += this.vector[i] * vec.vector[i];
        }
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);