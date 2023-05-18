/** HashMap **/
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        
        Map<Integer, Integer> map = new HashMap<>(); //map card number to its freq
        for (int num : hand) map.put(num, map.getOrDefault(num, 0) + 1);
        
        Arrays.sort(hand);
        for (int num : hand) {
            if (map.get(num) <= 0) continue;
            for (int i = 0; i < groupSize; i++) {
                int count = map.getOrDefault(num + i, 0);
                if (count <= 0) return false;
                map.put(num + i, count - 1);
            }
        }
        return true;
    }
}
//Time: O(n * log(n)); Space: O(n)

