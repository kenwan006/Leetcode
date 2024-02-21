class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last_loc = new int[26];
        for (int i = 0; i < s.length(); i++) last_loc[s.charAt(i) - 'a'] = i; //last position of each letter
        
        int start = 0, farthest = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            farthest = Math.max(farthest, last_loc[s.charAt(i) - 'a']);
            if (farthest == i) { //comes to the end of current partition
                res.add(i - start + 1);
                start = i + 1; //start of next partition
                farthest = 0;
            }
        }
        return res;
    }
}