class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26]; //init an array by couting words[0]
        for (char c : words[0].toCharArray()) count[c - 'a']++;
        
        for (int k = 1; k < words.length; k++) {
            int[] count1 = new int[26]; //count the letter in words[i]
            for (char c : words[k].toCharArray()) count1[c - 'a']++;
            //update count
            for (int i = 0; i < 26; i++) count[i] = Math.min(count[i], count1[i]);
        }
        
        //convert the count to the res string
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) { //j is the frequency of letter 'a' + i 
                char c = (char) ('a' + i);
                res.add(String.valueOf(c));
            }
        }
        return res;
    }
}