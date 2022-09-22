/** BFS + Hashset
* Change each letter in the beginWord, if the new word exists in the wordlist, then add it to the queue
* Pop out a word from the queue and repeat the last step until we find the endword
* Use a hashset to store the visited words
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int L = beginWord.length(); // each word has the same length
        int change = 1; 
        queue.add(beginWord);
        
        while(!queue.isEmpty()) {
            int size = queue.size(); // size of current level in the bfs
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                visited.add(word);
                if (word.equals(endWord)) return change;
                
                // replace the jth letter of word with 'a'  to 'z'
                for (int j = 0; j < L; j++) {
                    StringBuilder s = new StringBuilder(word);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        s.setCharAt(j, ch);
                        String newWord = s.toString();
                        if (set.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            change++;
        }
        return 0;
    }
}
               