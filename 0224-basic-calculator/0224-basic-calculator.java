class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0, sign = 1, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = c - '0';
                while (i < n - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += sign * num;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') { //push current res and sign to the stack, and reset them
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1; 
            } else if (c == ')') { //get the res within the "(*res*)", and apply it to the res in the stack
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}
//Time: O(n); Space: O(n)