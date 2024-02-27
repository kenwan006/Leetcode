class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = s.length();
        char op = '+';
        while (i < n) {
            //remove the leading space
            while (i < n && s.charAt(i) == ' ') i++;
            
            //check the operand
            int j = i, num = 0;
            while (j < n && Character.isDigit(s.charAt(j))) j++;
            num = Integer.parseInt(s.substring(i, j));
            i = j;
            
            //remove the trailing space
            while (i < n && s.charAt(i) == ' ') i++;
            
            
            //run operation
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
            }
            
            //check the operator
            if (i < n) op = s.charAt(i++);
            
        }
        
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}