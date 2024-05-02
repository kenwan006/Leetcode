class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int len = 2; len <= 9; len++) {
            for (int start = 1; start <= 10 - len; start++) {
                int num = 0;
                int next = start;
                for (int i = 0; i < len && next <= 9; i++) {
                    num = num * 10 + next;
                    next++;
                }
                if (num >= low && num <= high) res.add(num);
            }
        }
        return res;
    }
}