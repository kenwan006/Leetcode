class Solution {
    public int minimumKeypresses(String s) {
        Integer[] count = new Integer[26]; 
        Arrays.fill(count, 0);
        // letter with high freq should always to the 1st position on the button
        //eg, if a letter is the second char on button 1, then we say its positin is 9 + 1 = 10;
        
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        Arrays.sort(count, (a, b) -> b - a);
        
        int res = 0;
        for (int button = 1; button <= 26; button++) {
            int press = button % 9 == 0? button / 9 : button / 9 + 1; //press 1, 2 or 3 to get the letter on the button
            res += press * count[button - 1];
        }
        
        return res;
     }
}

//Time: O(n); Space: O(1)

