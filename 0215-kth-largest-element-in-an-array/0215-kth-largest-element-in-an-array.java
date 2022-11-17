/** QuickSort **/  
/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(0, nums.length - 1, k, nums);
    }
    
    private int quickSort(int low, int high, int k, int[] nums){
        int pivot = low; // choose the lowest index as the pivot
        int i = low;
        int j = high;
        while (i != j) {
            while (nums[j] > nums[pivot] && i < j) j--;
            while (nums[i] <= nums[pivot] && i < j) i++;
            swap(i, j, nums);
        }// low and high meet i = j
        swap(j, pivot, nums);
        
        int count = high - j + 1;
        if(count == k) return nums[j];
        if(count < k) return quickSort(low, j-1, k-count, nums);
        return quickSort(j+1, high, k, nums);
    }
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

Time: average O(nlongn); Space: O(1)
*/

/** Heap **/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //Initialize a heap including all nums
        for (int num : nums) {
            heap.offer(num);
        }
        //Pop out the smaller nums
        while (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    } 
}

//Time: O(nlongn); Space: O(n)