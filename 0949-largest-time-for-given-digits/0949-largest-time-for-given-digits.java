class Solution {
    StringBuilder sb;
    String time;
    boolean[] visited;
    public String largestTimeFromDigits(int[] arr) {
        sb = new StringBuilder();
        time = "";
        visited = new boolean[4];
        Arrays.sort(arr);
        backtrack(arr);
        return time;
    }
    
    private void backtrack(int[] arr) {
        if (sb.length() == 4) {
            char a = sb.charAt(0), b = sb.charAt(1), c = sb.charAt(2), d = sb.charAt(3);
            int h = (a - '0') * 10 + (b - '0');
            int m = (c - '0') * 10 + (d - '0');
            if (h >= 0 && h < 24 && m >= 0 && m < 60) time = "" + a + b + ":" + c + d;
        }
        
        for (int i = 0; i < 4; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(arr[i]);
            backtrack(arr);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}