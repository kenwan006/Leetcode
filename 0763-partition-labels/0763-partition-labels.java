class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] bounds = new int[26]; //right most index of the letter
        for (int i = 0; i < s.length(); i++) bounds[s.charAt(i) - 'a'] = i;
        
        //partition
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, bounds[s.charAt(i) - 'a']);
            
            //if the current char located at its rightmost position
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1; //start for next partition
            }
        }
        return res;
    }
}
//Time: O(n); Space: O(1)