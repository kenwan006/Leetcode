class SparseVector {
    List<int[]> list;
    SparseVector(int[] nums) {
        list = new ArrayList<>();
        //only add the non zero and its index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) list.add(new int[]{i, nums[i]});
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        int m = list.size(), n = vec.list.size();
        int i = 0, j = 0;
        while (i < m && j < n) {
            int idx1 = list.get(i)[0], idx2 = vec.list.get(j)[0];
            if (idx1 == idx2) {
                product += list.get(i++)[1] * vec.list.get(j++)[1];
            } else if (idx1 < idx2) {
                i++;
            } else {
                j++;
            }
        }
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);