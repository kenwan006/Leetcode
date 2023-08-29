class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backTracking(sb, 0, 0);
        return res;
    }
    
    private void backTracking(StringBuilder sb, int start, int dotNum) {
        if (start >= sb.length()) return;
        if (dotNum == 3) {
            if (valid(sb, start, sb.length() - 1)) res.add(sb.toString());
            return;
        }
        
        for (int i = start; i < sb.length(); i++) {
            if (!valid(sb, start, i)) break;
            sb.insert(i + 1, '.');
            backTracking(sb, i + 2, dotNum + 1); 
            sb.deleteCharAt(i + 1); //remove dot
        }
    }
    
    private boolean valid(StringBuilder sb, int start, int end) {
        if (sb.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for(int i = start; i <= end; i++){
            int digit = sb.charAt(i) - '0';
            num = num * 10 + digit;
            if(num > 255)
                return false;
        }
        return true;
    }
}