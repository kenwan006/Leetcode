class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        //store all freq to a list and sort them
        List<Integer> freq = new ArrayList<>();
        for (int f : map.values()) freq.add(f);
        Collections.sort(freq);
        
        int res = Integer.MAX_VALUE;
        int base = freq.get(0);
        int sum = 0;
        while (base != 0) {
            sum = partition(freq, base, base + 1);
            if (sum != 0) res = Math.min(res, sum);
            base--;
        }
        return res;
    }
    
    //for each f in freq, find the i and j that i * x + j * y = f
    private int partition(List<Integer> freq, int x, int y) {
        int sum = 0;
        for (int f : freq) {
            int ctn = Integer.MAX_VALUE; //count groups for each f
            for (int i = 0; i <= f / x; i++) {
                if ((f - i * x) % y != 0) continue;
                int j = (f - i * x) / y;
                ctn = Math.min(ctn, i + j);
            }
            if (ctn == Integer.MAX_VALUE) return 0; //no such i and j exist
            sum += ctn;
        }
        return sum;
    }
}