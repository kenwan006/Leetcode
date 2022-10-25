/** Straight Forward solution
* For each car, calcualte the time needed to arrive to the target if there is no block ahead of it. car[i] = {pos[i], time[i]};
* Sort the cars by their position and loop over the array starting from the end, which is closest to the target;
* If a new car i has longer time than the car x which has the current longest time, position[i] < position[x], but time[i] > time[x], then i will never catch up with x before reaching target - (prove it by contradiction!!). In this case we have to create a new fleet
* Otherwise if position[i] < position[x], but time[i] < time[x], then merge i to x, because i will catch up with x at some point.
*/