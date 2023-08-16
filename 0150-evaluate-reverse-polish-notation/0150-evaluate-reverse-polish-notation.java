class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        
        for (String s : tokens) {
            if (!operators.contains(s)) stack.push(Integer.parseInt(s));
            else {
                int x = stack.pop();
                int y = stack.pop();
                int z = 0;
                switch (s) {
                    case "+":
                        z = x + y;
                        break;
                    case "-":
                        z = y - x;
                        break;
                    case "*":
                        z = x * y;
                        break;
                    case "/":
                        z = y / x;
                        break;
                }
                stack.push(z);
            }
        }
        return stack.pop();
    }
}
//Time: O(n); Space: O(n)
