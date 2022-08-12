class Solution {
    public int evalRPN(String[] tokens) {
        HashSet<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stack = new Stack<>();
        int a = 0, b = 0, res = 0;
        
        for(String token : tokens) {
            if(!operators.contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            a = stack.pop();
            b = stack.pop();
            if(token.equals("+")) res = a + b;
            if(token.equals("-")) res = b - a;
            if(token.equals("*")) res = a * b;
            if(token.equals("/")) res = b / a;
            stack.push(res);
        }
        return stack.pop();       
    }
}
 