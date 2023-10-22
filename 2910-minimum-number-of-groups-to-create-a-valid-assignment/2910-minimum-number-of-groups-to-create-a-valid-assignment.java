class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int n = map.size();
        if (n == 1) return 1;
        
        //use an array to store all freqs and sort them
        int[] freq = new int[n];
        int i = 0;
        for (int f :  map.values()) freq[i++] = f;
        Arrays.sort(freq);
        
        int res = Integer.MAX_VALUE;
        int base = freq[0];
        int sum = 0;
        while (base != 0) {
            sum = partition(freq, base, base + 1);
            if (sum != 0) res = Math.min(res, sum);
            base--;
        }
        return res;
    }
    
    //for each f in freq, find the i and y that i * x + j * y = f
    private int partition(int[] freq, int x, int y) {
        int sum = 0;
        for (int f : freq) {
            int ctn = Integer.MAX_VALUE;
            for (int i = 0; i <= f / x; i++) {
                if ((f - i * x) % y != 0) continue;
                ctn = Math.min(ctn, i + (f - i * x) / y);
            }
            if (ctn == Integer.MAX_VALUE) return 0; //no such i and j exist
            sum += ctn;
        }
        return sum;
    }
}