/** Binary Search
* Check the total length of two arrays, N1 = nums1.length, N2 = num2.length;
* Let L = (N1 + N2 + 1) /2, R = (N1 + N2 + 2)
* If N1 + N2 is even, then get Lth largest num and Rth largest
* If N1 + N2 is odd, L = R, so we can always return (getKth(k = L) + getKth(k = R)) * 0/5;
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int k1 = (n + m + 1) / 2;
        int k2 = (n + m + 2) / 2;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, k1) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, k2)) * 0.5;
    }
    
    // get the kth largest number in two sorted arrays
    public double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // if one array is exhausted, then just return the kth number from the other array
        // len == 0 means start > end or start = end + 1;
        if (len1 == 0) return nums2[start2 + k - 1];
        if (len2 == 0) return nums1[start1 + k - 1];
        
        // if k == 1, which means both array has only 1 num, so just rerturn the minimum one
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        
        // Recursion, elimiate first k/2 numbers from the smaller array
        int mid1 = start1 + Math.min(len1, k / 2) - 1;
        int mid2 = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[mid1] < nums2[mid2]) { //remove all nums before index mid1, including mid1
            return getKth(nums1, mid1 + 1, end1, nums2, start2, end2, k - (mid1 - start1 + 1));
        } else { //remove all nums before index mid2, including mid2
            return getKth(nums1, start1, end1, nums2, mid2 + 1, end2, k - (mid2 - start2 + 1));
        }
    }
}

//Time: O(log(m+n)); Space: O(1)