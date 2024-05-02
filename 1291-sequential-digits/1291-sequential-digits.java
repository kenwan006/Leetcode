class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int start = 1; start <= 8; start++) {
            int num = start;
            int next = start + 1;
            while (next <= 9) {
                num = num * 10 + next;
                next++;
                if (num >= low && num <= high) res.add(num);
            }
        }
        Collections.sort(res);
        return res;
    }
}