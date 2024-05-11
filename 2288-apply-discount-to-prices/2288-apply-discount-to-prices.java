class Solution {
    public String discountPrices(String sentence, int discount) {
        int n = sentence.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            char c = sentence.charAt(i);
            if (c != '$') sb.append(c);
            else {
                sb.append(c);
                if (i > 0 && sentence.charAt(i - 1) != ' ') {
                    i++;
                    continue; //ensure char before '$' is ' '
                }
                int j = endIdx(sentence, i + 1);
                String sub = sentence.substring(i + 1, j);
                if (sub != "") {
                    double price =  (Long.valueOf(sub) * 1.0 * (100 - discount) / 100);
                    sb.append(String.format("%.2f", price));
                     sb.append(" ");
                     i = j;
                } 
            }
            i++;
        }
        if (sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private int endIdx(String s, int i) {
        int n = s.length();
        int j = i;
        while (j < n && Character.isDigit(s.charAt(j))) {
            j++;
        }
        
        if (j == n || s.charAt(j) == ' ') return j;
        else return i; //invalid price
    }
}