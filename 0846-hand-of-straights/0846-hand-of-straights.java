class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) map.put(num, map.getOrDefault(num, 0) + 1);
        
        Arrays.sort(hand);
        
        for (int num : hand) {
            if (map.get(num) == 0) continue; //no such num to select
            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(num) || map.get(num) == 0) return false; //check if the next num is able to select
                
                map.put(num, map.get(num) - 1);
                num++;
            }
        }
        return true;
    }
}