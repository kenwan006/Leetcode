/** BFS
* keep substract a perfect square number from the target unitl it becomes 0
* eg, n = 10, the first square number could be 1, 4, 9, after subtraction, the remainder would be 9, 6, 1. 
* Add all the possible remainders to a queue, and poll one by one. For each polled number, repeate the above the process.
* When the remainder becomes 0, the total subtractions would be the number of square numbers.
*/
class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                //add the remainder to queue after subtraction to num
                for (int j = 1; j * j <= num; j++) {
                    int remainder = num - j * j;
                    if (remainder == 0) return step;
                    if (!visited.contains(remainder)) { //skip number that's already visited
                        queue.offer(remainder);
                        visited.add(remainder);
                    }
                }       
            }
        }
        return step;
    }
}
//Time: O(n); Space: O(n)