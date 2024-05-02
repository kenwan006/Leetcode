class Solution {
    public String reorganizeString(String s) {
        int[] ctns = new int[26];
        for (char c : s.toCharArray()) {
            ctns[c - 'a']++;
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (ctns[i] > 0) heap.offer(new int[]{i, ctns[i]});
        }
        
        StringBuilder sb = new StringBuilder();
        while (heap.size() > 1) {
            int[] first = heap.poll();
            int[] second = heap.poll();
            
            sb.append((char) (first[0] + 'a'));
            if (--first[1] > 0) heap.offer(first);
            
            sb.append((char) (second[0] + 'a'));
            if (--second[1] > 0) heap.offer(second);
        }
        
        if (heap.size() == 1) {
            int[] last = heap.poll();
            if (last[1] > 1) return "";
            else sb.append((char)(last[0] + 'a'));
        }
        
        return sb.toString();
    }
}

//Time: O(n * log(k)); Space: O(k)