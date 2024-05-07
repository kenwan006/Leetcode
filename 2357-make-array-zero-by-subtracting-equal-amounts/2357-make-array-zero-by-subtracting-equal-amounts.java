class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> heap1 = new PriorityQueue<>();
        for (int num : nums) {
            if (num > 0) heap1.offer(num);
        }
        
        int count = 0;
        
        while (!heap1.isEmpty()) {
            int x = heap1.poll();
            PriorityQueue<Integer> heap2 = new PriorityQueue<>();
            while (!heap1.isEmpty()) {
                int num = heap1.poll();
                if (num > x) heap2.offer(num - x);
            }
            heap1 = heap2;
            count++;
        }
        
        return count;
    }
}