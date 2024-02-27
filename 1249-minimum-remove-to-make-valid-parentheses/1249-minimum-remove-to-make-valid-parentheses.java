class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>(); //indices of parentheis not removed yet
       
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) continue;
            if (c == '(') stack.push(i);
            if (c == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
                else stack.push(i);
            }  
        }
        
        Set<Integer> set = new HashSet<>(); //indices of parentheis that has to be removed
        while (!stack.isEmpty()) set.add(stack.pop());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}