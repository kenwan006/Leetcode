class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>(); //index of the '(' 
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty()) {
                    sb.setCharAt(i, '#');
                } else {
                    stack.pop();
                }
            } else if (c == '(') {
                stack.push(i);
            }
        }
        
        //remove the remainig '(' in the stack
        while (!stack.isEmpty()) sb.setCharAt(stack.pop(), '#');
        
        //remove all '#'
        String res = "";
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c != '#') res += c;
        }
        return res;
    }
}