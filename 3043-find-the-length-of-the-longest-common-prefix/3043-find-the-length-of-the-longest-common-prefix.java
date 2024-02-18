class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        //put all possible prefix of num in arr1 to a set
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            String str = num + "";
            for (int i = 1; i <= str.length(); i++) {
                set.add(Integer.parseInt(str.substring(0, i)));
            }
        }
        
        //find the prefix in arr2 and check if it's included in the set
        int res = 0;
        for (int num : arr2) {
            String str = num + "";
            for (int i = 1; i <= str.length(); i++) {
                int prefix = Integer.parseInt(str.substring(0, i));
                if (set.contains(prefix)) res = Math.max(res, i);
            }
        }
        return res;
    }
}