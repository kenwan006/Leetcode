class Solution {
    public int partitionString(String s) {
        Set<Character> visited = new HashSet<>();
        int res = 1;
        for (char c : s.toCharArray()) {
            if (visited.contains(c)) {
                visited.clear();
                res++;
            }
            visited.add(c);
        }
        return res;
    }
}
//Time: O(n); Space: O(n)
