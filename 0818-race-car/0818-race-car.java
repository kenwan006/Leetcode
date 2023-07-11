/** BFS 
* Note the bound the race car can reach in order to get the shortest sequence of instructions
* The next position of the race car should be > 0 && < target * 2
**/
class Solution {
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1}); //start with position = 0, spped = 1
        Set<String> visited = new HashSet<>();
        int step = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int position = curr[0], speed = curr[1];
                
                if (position == target) return step;
                
                //if current instructio is 'A'
                int next_position = position + speed;
                int next_speed = speed * 2;
                String s = next_position + " with " + next_speed;
                if (!visited.contains(s) && next_position > 0 && next_position < target * 2) {
                    visited.add(s);
                    queue.offer(new int[]{next_position, next_speed});
                }          
                
                //if current iinstruction is 'R'
                next_position = position; //stay
                next_speed = speed > 0? -1 : 1;
                s = next_position + " with " + next_speed;
                if (!visited.contains(s) && next_position > 0 && next_position < target * 2) {
                    queue.offer(new int[]{next_position, next_speed});
                }
                    
            }
            step++;
        }
        return -1;
    }
}
//Time: O(n * log(n)); Space: O(n)
