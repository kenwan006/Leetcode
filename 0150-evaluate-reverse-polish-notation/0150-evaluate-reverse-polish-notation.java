/** Stack **/
class Solution {
    public int evalRPN(String[] tokens) {
        List<String> operators = Arrays.asList(new String[] {"+", "-", "*", "/"});
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!operators.contains(s)) stack.push(Integer.parseInt(s));
            else {
                int y = stack.pop(), x = stack.pop(); //two operands
                int res = 0;
                switch(s) {
                    case "+" : 
                        res = x + y;
                        break;
                    case "-" : 
                        res = x - y;
                        break;
                    case "*":
                        res= x * y;
                        break;
                    case "/":
                        res= x / y;
                        break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
//Time: O(n); Space: O(n)