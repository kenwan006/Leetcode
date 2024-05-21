class Solution {
    public String frequencySort(String s) {
        //calculate the frequency for each char in the s
        Map<Character, Integer> map = new HashMap<>(); 
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //put each c to a max heap according to their frequency in s 
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()) heap.offer(c);
        
        //concatenate
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            char c = heap.poll();
            int count = map.get(c);
            for (int i = 0; i < count; i++) sb.append(c);
        }
        return sb.toString();
    }
}

//Time: O(n + m * log(m))

