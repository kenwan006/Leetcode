/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/** DFS
* For each item in the nestedlist,
* If it's an integer, then item * current_depth, stop dfs for this item;
* If it's an list, check each of them..
*/
class Solution {
    int res = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        for (NestedInteger item : nestedList) {
            res += dfs(item, 1);
        }
        return res;
    }
    
    public int dfs (NestedInteger item, int depth) {
        if (item.isInteger()) return item.getInteger() * depth;
        int ans = 0;
        for (NestedInteger i : item.getList()) {
            ans += dfs(i, depth + 1);
        }
        return ans;
    }
}
//Time: O(n); Space: O(log(n))