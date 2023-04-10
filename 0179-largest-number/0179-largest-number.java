/** Sorting *
* Concatenation of two integers is not as convenient as that of two strings. eg, num1="81", num2="9", 981 > 819
* Covert each num in the array to a string, and sort all the strings based on a custom comparator - in descending order
* If s1 + s2 < s2 + s1, then s2 should appear before s1
*/
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = nums[i] + "";
        
        //sort based on a custom comparator
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c2.compareTo(c1);
            }
        };
        Arrays.sort(ss, comparator);
        
        //convert the string array to one complete string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(ss[i]);
        if (sb.charAt(0) == '0') return "0"; //leading 0s
        return sb.toString();
    }
}
//Time: O(n * log(n)); Space: O(n)