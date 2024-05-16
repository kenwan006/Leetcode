class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        for (int num : nums) {
            if (seen.contains(num)) res.add(num);
            else seen.add(num);
        }
        return res;
    }
}