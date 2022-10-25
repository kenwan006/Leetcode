/** Straight Forward solution
* For each car, calcualte the time needed to arrive to the target if there is no block ahead of it. car[i] = {pos[i], time[i]};
* Sort the cars by their position and loop over the array starting from the end, which is closest to the target;
* If a new car i has longer time than the car x which has the current longest time, position[i] < position[x], but time[i] > time[x], then i will never catch up with x before reaching target - (prove it by contradiction!!). In this case we have to create a new fleet
* Otherwise if position[i] < position[x], but time[i] < time[x], then merge i to x, because i will catch up with x at some point.
*/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        double [][] cars = new double [N][2];
        for (int i = 0; i < N; i++) cars[i] = new double[] {position[i], (target - position[i]) * 1.0 / speed[i]};
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0])); // sort the cars by their position in ascending order
        
        int fleet = 0;
        double longest = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (cars[i][1] > longest) {
                longest = cars[i][1];
                fleet++;
            }
        }
        
        return fleet;
    }
}

//Time: O(nlogn); Space: O(n * n)