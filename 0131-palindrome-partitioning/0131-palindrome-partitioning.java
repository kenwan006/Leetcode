/*Backtracking
* Set a start index i and end index j, iterate j through the string s, check all possible subsrting s(i, j);
* If the substring is palindrome, then set the new start = j + 1 and repeate the above process until the end of the string
*/

class Solution {
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();
    
    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }
    
    private void backtrack(String s, int start) {
        // base case
        if (start == s.length()) {
            res.add(new LinkedList(track));
            return;
        }
        
        // backtrack
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                track.add(s.substring(start, end + 1));
                backtrack(s, end + 1);
                track.removeLast();
            }
        }
    }
    //check if the string s(i, j) is a palindrome
    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}

//Time: O(2^n); Space: O(n)