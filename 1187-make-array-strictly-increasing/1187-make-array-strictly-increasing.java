/** DP **
* Iterate over arr1, at each position,  record all the possible states it can reach and the number of operations needed to reach this state;
* Use two hashMap - {state : count} dp and temp to record states for reaching positino i-1 and position i
* compare arr1[i] with previous state in the dp
* If arr1[i] < prev, find the smallest num in arr2 that is greater than prev and repalce arr1[i] in arr1, add this new state to temp
* If arr1[i] > prev, either keep arr1[i] unchanged, or find the smallest num in arr2 that is greater than prev and repalce arr1[i] in arr1, add new state to temp
* Let dp = temp, and reset temp for next iteration
*/
class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Map<Integer, Integer> dp = new HashMap<>(); // state -> count of operations to reach this state
        dp.put(-1, 0);//init state
        
        Arrays.sort(arr2);
        int n = arr2.length;
        
        for (int i = 0; i < arr1.length; i++) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int prev : dp.keySet()) {
                // arr1[i] stay unchanged
                if (arr1[i] > prev) {
                   temp.put(arr1[i], Math.min(temp.getOrDefault(arr1[i], Integer.MAX_VALUE), dp.get(prev)));
                }
                //find the index of the smallest number greater than prev in arr2
                int index = binarySearch(arr2, prev);
                if (index < n) {
                    temp.put(arr2[index], Math.min(temp.getOrDefault(arr2[index], Integer.MAX_VALUE), dp.get(prev) + 1));
                }     
            }
            dp = temp;
        }
        
        int res = Integer.MAX_VALUE;
        for (int val : dp.values()) {
            res = Math.min(res, val);
        }
        return res == Integer.MAX_VALUE? -1 : res;
    }
    
    //return the index of the smallest number greater (Not equal) than target in an ordered array
    private int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length; // if return arr.length, it means target > the greatest
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
//Time: O(m * n * log(n)); Space: O(m)