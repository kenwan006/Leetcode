class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        
        //each pair{i, j} in the list - jth letter of ith word
        List<int[]> [] waiting = new List[26]; 
        for (int i = 0; i < 26; i++) waiting[i] = new ArrayList<>();
        
        //group by their 0th letter
        for (int i = 0; i < words.length; i++) {
            int idx = words[i].charAt(0) - 'a';
            waiting[idx].add(new int[]{i, 0});
        }
        
        //check each letter of s and see which group to advance
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            List<int[]> advance = waiting[idx]; //copy the idx waiting group to advance 
            waiting[idx] = new ArrayList<>();  //and reset this waiting group for futher potential insertion
             
            for (int[] arr : advance) {
                int i = arr[0], j = arr[1];
                j++; //advance jth letter of ith word to j+1
                if (j == words[i].length()) {
                    count++;
                }else {
                    idx = words[i].charAt(j) - 'a';
                    waiting[idx].add(new int[]{i, j});
                }
            }
        }
        return count;
    }
}