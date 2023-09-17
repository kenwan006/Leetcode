/** Binary Search **/
class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long lo = 0, hi = (long) 1e9; //init a range for the number of alloys that can be created
        long ans = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (creatable(n, k, mid, budget, composition, stock, cost)) {
                lo = mid + 1;
                ans = mid; //mark the rightmost index 
            } else {
                hi = mid - 1;
            }
        }
        return (int) ans;
    }
    
    //check if the budget can cover the cost for creating qty alloys
    public boolean creatable (int n, int k, long qty, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long minCost = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) { // ith machine
            long currCost = 0;
            for (int j = 0; j < n; j++) {// jth metal
                if (stock.get(j) >= composition.get(i).get(j) * qty) continue; //stock enough to cover the cost
                currCost += (composition.get(i).get(j) * qty - stock.get(j)) * cost.get(j);
            }
            minCost = Math.min(minCost, currCost);
        }
        return budget >= minCost;
    }
}
//Time: (k * n * log(N)); Space: O(1)