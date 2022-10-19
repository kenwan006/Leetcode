/** HashMap 
* Map<String, List<String>> map -- <a string of freq count of each char : strings have the same freq >
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        //Put each string s into hashmap bucket
        for (String s : strs) {
            String count = encode(s);
            if (!map.containsKey(count)) map.put(count, new LinkedList<String>());
            map.get(count).add(s);
        }
        
        //Gather all values in the hashmap
        for (List<String> list : map.values()) {
            res.add(list);
        }
        
        return res;
    }
    
    
    //count the freq of each char in s and encodes the freq into a string
    private String encode(String s) {
        char[] count = new char[26];
        for (char ch : s.toCharArray()) 
            count[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) sb.append(count[i]);
        return sb.toString();
    }
}