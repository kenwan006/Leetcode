class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = '+'; //+0
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            } else if (c == '(') { //find the ')', and push the value of block '( )' to stack
                int j = i;
                int count = 1;
                while (count > 0 && j < s.length()) {
                    j++;
                    if (s.charAt(j) == '(') count++;
                    if (s.charAt(j) == ')') count--;
                }
                num = calculate(s.substring(i + 1, j));
                i = j;
            } else {
                helper(op, num, stack);
                op = c;  //operator for the next valid num
                num = 0;
            }
        }
        
        helper(op, num, stack); //don't forget to push last num to stack
        
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
    
    private void helper(char op, int num, Stack<Integer> stack) {
        switch(op) {
            case '+':
                stack.push(num);
                break;
            case '-':
                stack.push(-num);
                break;
            case '*':
                stack.push(num * stack.pop());
                break;
            case '/':
                stack.push(stack.pop() / num);
                break;
            default:
                break;
        }
    }
}