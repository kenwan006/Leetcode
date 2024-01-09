/** BFS *
* Generate all the string by removing one parenthesis, either '(' or ')';
* Check if any of the generated string is valid, if yes, return all; if no, repeated the first step for each newly generated string
*/
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited =  new HashSet<>();
        queue.offer(s);
        visited.add(s);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                if (isValid(curr)) {
                    res.add(curr);
                } else {
                    //remove each parentehsis
                    for (int i = 0; i < curr.length(); i++) {
                        if (s.charAt(i) != '(' && s.charAt(i) != ')') continue; //skip the non parenthesis
                        String nxt = curr.substring(0, i) + curr.substring(i + 1);
                        if (visited.contains(nxt)) continue;
                        visited.add(nxt);
                        queue.offer(nxt);
                    }
                }
            }
            
            if (!res.isEmpty()) {
                return res;
            }
        }
        return null;
        
    }
    
    //check if a string is valid
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}