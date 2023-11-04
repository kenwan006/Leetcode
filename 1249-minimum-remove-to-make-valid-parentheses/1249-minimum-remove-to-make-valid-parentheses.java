class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>(); //index of the '(' 
        Set<Integer> removed = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty()) {
                    removed.add(i);
                } else {
                    stack.pop();
                }
            } else if (c == '(') {
                stack.push(i);
            }
        }
        
        while (!stack.isEmpty()) removed.add(stack.pop());
        
        String res = "";
        for (int i = 0; i < n; i++) {
            if (!removed.contains(i)) res += s.charAt(i);
        }
        return res;
     
    }
}