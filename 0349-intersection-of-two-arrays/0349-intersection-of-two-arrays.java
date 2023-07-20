class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        for (int num : nums1) set.add(num);
        for (int num : nums2) {
            if (set.contains(num) && !res.contains(num)) res.add(num);
        }
        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}