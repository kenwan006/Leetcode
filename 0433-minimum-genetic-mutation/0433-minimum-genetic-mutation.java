class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> banks = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String s : bank) banks.add(s);
        if (!banks.contains(endGene)) return -1;
        
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int step = 0;
        char[] chs = new char[]{'A', 'C', 'G', 'T'};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String s = queue.poll();
                if (s.equals(endGene)) return step;
                visited.add(s);
                
                for (int i = 0; i < 8; i++) {
                    StringBuilder sb = new StringBuilder(s);
                    for (char ch : chs) {
                        if (sb.charAt(i) == ch) continue;
                        sb.setCharAt(i, ch); //mutate the ith char in the gene string
                        String ss = sb.toString();
                        if (banks.contains(ss) && !visited.contains(ss)) queue.offer(ss);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
//Time: O(B); Space: O(1)
