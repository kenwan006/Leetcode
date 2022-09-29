BFS
- No need to check the cell 0 because it's nearest to itself; for the noo-zero initialize them to be MAX_VALUE and then update them every time we check it.
- Add the unchecked cell to a queue, and check all the neighbors for each cell. If the neighbor will be updated with smaller value, then we have to add this neighbor to the queue for further check.
​
DP is faster and less space needed
In DP, we can only use prevous values if they're already computed.
In this problem, a cell has at most 4 neighbors that are left, top, right, bottom. If we use dynamic programming to compute the distance of the current cell based on 4 neighbors simultaneously, it's impossible because we are not sure if distance of neighboring cells is already computed or not.