class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        
        List<Integer> res = new ArrayList<>();
        for (int len = lowLen; len <= highLen; len++) {
            for (int start = 0; start <= 9 - len; start++) {
                int num = Integer.parseInt(s.substring(start, start + len));
                if (num >= low && num <= high) res.add(num);
            }
        }
        return res;
    }
}