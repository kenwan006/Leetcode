class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        
        int L = beginWord.length();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) return step;
                
                for (int j = 0; j < L; j++) {
                    StringBuilder sb = new StringBuilder(currWord);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String word = sb.toString();
                        if (!visited.contains(word) && dict.contains(word)) {
                            queue.offer(word);
                            visited.add(word);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
//Time: O(n * m); Space: O(n + m)