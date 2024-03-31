class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int n = chars.length, count = 1;
        
        for (int i = 1; i < n; i++) {
            if (chars[i] != chars[i - 1]) {
                if (count != 1) sb.append(count);
                sb.append(chars[i]);
                count = 1;
            } else {
                count++;
            }
        }

        if (count != 1) sb.append(count);
        
        int len = sb.length();
        for (int i = 0; i < len; i++) {
            chars[i] = sb.charAt(i);
        }
        return len;
    }
}