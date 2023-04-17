/**Stack 
* push the open brackets to the stack
**/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {//close bracket
                if (!stack.isEmpty() && stack.peek() == map.get(c)) stack.pop();
                else return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
//Time: O(n); Space: O(n)