/** Greedy **/
class Solution {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] last = new int[10]; //last[i] - means the position of last apprearance of digit i
        for (int i = 0; i < chars.length; i++) {
            last[chars[i] - '0'] = i;
        }
        
        for (int i = 0; i < chars.length; i++) {
            //find the largest digit behind i and has to be greater than chars[i]
            for (int d = 9; d > chars[i] - '0'; d--) { 
                int j = last[d];
                if (j > i) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}