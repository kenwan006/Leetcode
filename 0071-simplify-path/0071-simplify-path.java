class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : components) {
            if (s.equals(".") || s.isEmpty()) continue;
            else if (s.equals(".."))  {
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s);
            }            
        }
        
        StringBuilder sb = new StringBuilder();
        //Iteration over a stack goes from bottom to top!
        for (String s : stack) sb.append("/").append(s); 
        
        return stack.size() > 0? sb.toString() : "/";
    }
}
//Time: O(n); Space: O(n)
