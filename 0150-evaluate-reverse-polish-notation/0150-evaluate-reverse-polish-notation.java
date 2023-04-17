/** Stack **/
class Solution {
    public int evalRPN(String[] tokens) {
        List<String> operators = Arrays.asList(new String[] {"+", "-", "*", "/"});
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!operators.contains(s)) stack.push(Integer.parseInt(s));
            else {
                int x = stack.pop(), y = stack.pop(); //two operands
                if (s.equals("+")) stack.push(x + y);
                if (s.equals("-")) stack.push(y - x);
                if (s.equals("*")) stack.push(x * y);
                if (s.equals("/")) stack.push(y / x);
            }
        }
        return stack.pop();
    }
}
//Time: O(n); Space: O(n)