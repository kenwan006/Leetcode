class Solution {
    public int partitionString(String s) {
        int[] lastSeen = new int[26]; //position of char seen last time
        Arrays.fill(lastSeen, -1);
        
        int count = 1;
        int currStart = 0; // start index of current partition
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastSeen[c - 'a'] >= currStart) { //start a new partition
                currStart = i;
                count++;
            }
            lastSeen[c - 'a'] = i;
        }
        return count;
    }
}
//Time: O(n); Space: O(1)

