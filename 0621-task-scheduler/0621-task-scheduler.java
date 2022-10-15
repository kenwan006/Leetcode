/** Greedy 
1. First find the taks with most frequency, and arrange them
2. Then put the next frequent tasks into the idle time slots from step 1
3. Repeate the step 2 until there is no task availale or idle slots left.
*/


class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] fs = new int[26];
        int f_max = 0, count_max = 0;
        
        // find the most frenquency
        for (char task : tasks) {
            fs[task - 'A']++;
            f_max = Math.max(f_max, fs[task - 'A']);
        }
        
        // count the tasks with the most frequency, eg. A and B both has frenquency fmax
        for (int f : fs) {
            if (f == f_max) count_max++;
        }
        
        // calculate the total time needed
        int part_length = n - (count_max - 1);
        int part_num = f_max - 1;
        int init_idle = part_length * part_num;
        int rest_task = tasks.length - count_max * f_max;
        int final_idle = init_idle - rest_task;
        return tasks.length + (final_idle > 0 ? final_idle : 0);
       
    }
}