class Solution {
    public int compareVersion(String version1, String version2) {
        //split version string by the '.'
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        
        //compare each digit in s1 and s2
        int m = s1.length, n = s2.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            String str1 = s1[i];
            String str2 = s2[j];
            int res = compare(str1, str2);
            if (res != 0) return res;
            i++;
            j++;
        }
        
        while (i < m) {
            for (char c : s1[i].toCharArray()) {
                if (c != '0') return 1;
            }
            i++;
        }
        
        while (j < n) {
            for (char c : s2[j].toCharArray()) {
                if (c != '0') return -1;
            }
            j++;
        }
        
        return 0;
    }
    
    //compare two strings x and y
    private int compare (String x, String y) {
        int m = x.length(), n = y.length();
        int i = 0, j = 0;
        //remove leading 0s
        while (i < m && x.charAt(i) == '0') i++;
        while (j < n && y.charAt(j) == '0') j++;
        
        int len1 = m - i;
        int len2 = n - j;
        
        if (len1 < len2) return -1;
        else if (len1 > len2) return 1;
        
        //if same length
        while (i < m && j < n) {
            if (x.charAt(i) < y.charAt(j)) return -1;
            if (x.charAt(i) > y.charAt(j)) return 1;
            i++;
            j++;
        }
        return 0;
    }
}