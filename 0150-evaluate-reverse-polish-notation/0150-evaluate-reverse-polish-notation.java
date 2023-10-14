class Solution {
    public int evalRPN(String[] tokens) {
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!operators.contains(s)) {
                stack.push(Integer.parseInt(s));
                continue;
            }
            int x = stack.pop();
            int y = stack.pop();
            int res = 0;
            switch (s) {
                case "+":
                    res = x + y;
                    break;
                case "-":
                    res = y - x;
                    break;
                case "*":
                    res = x * y;
                    break;
                case "/":
                    res = y / x;
                    break;
                default:
                    break;
            }
            stack.push(res);
        }
        return stack.pop();
    }
}