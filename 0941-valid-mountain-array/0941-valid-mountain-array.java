class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 1, n = arr.length;
        while (i < n && arr[i] > arr[i - 1]) {
            i++;
        }
        
        //if it decrease in the beginning, or increase all the way to the end
        if (i == 1 || i == n) return false; 
        
        
        while (i < n && arr[i] < arr[i - 1]) {
            i++;
        }
        return i == n;
    }
}