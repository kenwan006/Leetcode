class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (Character.isLetter(abbr.charAt(j))) {
                if (word.charAt(i) == abbr.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else {
                //get the substring length
                int k = j;
                if (abbr.charAt(k) == '0') return false; //leading zeros
                while (k < n && Character.isDigit(abbr.charAt(k))) k++;
                int len = Integer.parseInt(abbr.substring(j, k));
                
                i = i + len; //update the pointer for word
                j = k; // update the pointer for abbr
            }
        }
        return i == m && j == n;
    }
}