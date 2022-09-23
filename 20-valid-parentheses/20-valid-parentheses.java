/* stack + hashmap
* use a hashmap to include all right brackets, if not in the map, which means it is left bracket and will be pushed to the stack
* check each char in the string, if the char is in the map then pop out one char from the stack and see if they match, if the char is not in the map * then push it to the stack.
**/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                // always pop out the top element form stack
                // if r paris with the current ch, do nothing; if not pair then return false;
                if (stack.isEmpty() || map.get(ch) != stack.pop()) return false;
            }
            else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}